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
		BigDecimal total = BigDecimal.ZERO;
		List<InvoiceLine> invoiceLineList = inv.getInvoiceLine();

		for (InvoiceLine invoiceLine : invoiceLineList) {
			total = total.add(invoiceLine.getExSubTotal());
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
		Invoice invoice = new Invoice();
		invoice.setCustomer(sale.getCustomer());
		invoice.setDateOfInvoice(LocalDate.now());
		invoice.setExTaxTotal(sale.getExTaxTotal());
		invoice.setInTaxTotal(sale.getInTaxTotal());
		invoice.setAccountingCodeCustomer("411-" + invoice.getCustomer().getLastName());

		List<SaleOrderLine> saleOrderLineList = sale.getSaleOrderLine();

		for (SaleOrderLine saleOrderLine : saleOrderLineList) {
			InvoiceLine invoiceLine = new InvoiceLine();
			invoiceLine.setProduct(saleOrderLine.getProduct());
			invoiceLine.setDescription(saleOrderLine.getDescription());
			invoiceLine.setQty(saleOrderLine.getQty());
			invoiceLine.setExTaxPrice(saleOrderLine.getExTaxPrice());
			invoiceLine.setExSubTotal(saleOrderLine.getExSubTotal());
			invoiceLine.setTax(saleOrderLine.getTax());
			invoiceLine.setInSubTotal(saleOrderLine.getInSubTotal());
			invoiceLine.setAccountingAccount(saleOrderLine.getProduct().getAccountingAccount());
			invoice.addInvoiceLine(invoiceLine);
		}

		Beans.get(InvoiceRepository.class).save(invoice);

		return invoice;

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
