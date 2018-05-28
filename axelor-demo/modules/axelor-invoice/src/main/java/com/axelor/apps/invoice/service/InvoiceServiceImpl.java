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
		
		BigDecimal total = BigDecimal.ZERO;
		List<InvoiceLine> invoiceLineList = inv.getInvoiceLine();
	 	
	 	for (InvoiceLine invoiceLine : invoiceLineList) {
			total = total.add(invoiceLine.getInSubTotal());
		}
	 	
	 	return total;
		
	}

	@Override
	@Transactional
	public Invoice cpyFromSaleToInvoice(SaleOrder sale) {
		Invoice invoice = new Invoice();
		invoice.setCustomer(sale.getCustomer());
		invoice.setDateOfInvoice(LocalDate.now());
		invoice.setExTaxTotal(sale.getExTaxTotal());
		invoice.setInTaxTotal(sale.getInTaxTotal());
		
		List<SaleOrderLine> saleOrderLineList = sale.getSaleOrderLine();
		
		for (SaleOrderLine sol : saleOrderLineList) {
			InvoiceLine invoiceLine = new InvoiceLine();
			invoiceLine.setProduct(sol.getProduct());
			invoiceLine.setDescription(sol.getDescription());
			invoiceLine.setQty(sol.getQty());
			invoiceLine.setExTaxPrice(sol.getExTaxPrice());
			invoiceLine.setExSubTotal(sol.getExSubTotal());
			invoiceLine.setTax(sol.getTax());
			invoiceLine.setInSubTotal(sol.getInSubTotal());
			invoice.addInvoiceLine(invoiceLine);
		}
		
		Beans.get(InvoiceRepository.class).save(invoice);
		
		return invoice;
		
	}


	

}
