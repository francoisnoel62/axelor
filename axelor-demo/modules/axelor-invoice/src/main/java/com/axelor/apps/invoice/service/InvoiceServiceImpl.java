package com.axelor.apps.invoice.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.axelor.inject.Beans;
import com.axelor.invoice.db.Invoice;
import com.axelor.invoice.db.InvoiceLine;
import com.axelor.invoice.db.repo.InvoiceRepository;
import com.axelor.sale.db.SaleOrder;
import com.axelor.sale.db.SaleOrderLine;
import com.axelor.sale.db.StatusEnum2;
import com.google.inject.persist.Transactional;

public class InvoiceServiceImpl implements InvoiceService {

	@Override
	public BigDecimal calculateExTaxTotalPrice(Invoice inv) {
		BigDecimal total = BigDecimal.ZERO;// On initialise le resultat a zero
		List<InvoiceLine> invoiceLineList = inv.getInvoiceLine();// On recupere
																	// une liste
																	// de
																	// "invoice
																	// lines"

		for (InvoiceLine invoiceLine : invoiceLineList) {// Pour chaque ligne
															// d'invoice dans la
															// liste de invoice
															// lines...
			total = total.add(invoiceLine.getExSubTotal());// ...on recupere le
															// total HT et on
															// l'additionne au
															// resultat
		}

		return total;
	}

	@Override
	public BigDecimal calculateInTaxTotalPrice(Invoice inv) {
		return inv.getInvoiceLine().stream().map(x -> x.getInSubTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Override
	@Transactional
	public Invoice cpyFromSaleToInvoice(SaleOrder sale) {
		Invoice invoice = new Invoice();// On crée une nouvelle invoice
		invoice.setCustomer(sale.getCustomer());// On "set" chaque champ en
												// recuperant ceux de la
												// commande
		invoice.setDateOfInvoice(LocalDate.now());
		invoice.setExTaxTotal(sale.getExTaxTotal());
		invoice.setInTaxTotal(sale.getInTaxTotal());
		invoice.setAccountingCodeCustomer("411-" + invoice.getCustomer().getLastName());

		List<SaleOrderLine> saleOrderLineList = sale.getSaleOrderLine();// On
																		// recupère
																		// la
																		// liste
																		// de
																		// "sale
																		// order"...

		for (SaleOrderLine saleOrderLine : saleOrderLineList) {// ... puis on la
																// parcours pour
																// (a chaque
																// ligne de
																// commande):
			InvoiceLine invoiceLine = new InvoiceLine();// ...créer une ligne de
														// facture...
			invoiceLine.setProduct(saleOrderLine.getProduct());// .. puis recup
																// chaque champ
																// de la liste
																// de
																// commande...
			invoiceLine.setDescription(saleOrderLine.getDescription());// et
																		// "set"
																		// les
																		// lignes
																		// de
																		// factures
			invoiceLine.setQty(saleOrderLine.getQty());
			invoiceLine.setExTaxPrice(saleOrderLine.getExTaxPrice());
			invoiceLine.setExSubTotal(saleOrderLine.getExSubTotal());
			invoiceLine.setTax(saleOrderLine.getTax());
			invoiceLine.setInSubTotal(saleOrderLine.getInSubTotal());
			invoiceLine.setAccountingAccount(saleOrderLine.getProduct().getAccountingAccount());
			invoice.addInvoiceLine(invoiceLine);// On n'oublie pas d'ajouter
												// l'entité "lignes de factures"
												// qu'on vient de créer dans la
												// facture
		}

		Beans.get(InvoiceRepository.class).save(invoice);// Persistance de la
															// nouvelle facture
															// créée

		return invoice;// renvoie de la facture créée pour l'utiliser dans le
						// Controller

	}

	@Override
	@Transactional
	public void toInvoiceLateSaleOrder(List<SaleOrder> lateSO) {
		lateSO.forEach(saleOrder -> {
			saleOrder.setInvoice(cpyFromSaleToInvoice(saleOrder));
			saleOrder.setState2(StatusEnum2.INVOICED);
		});
	}

}
