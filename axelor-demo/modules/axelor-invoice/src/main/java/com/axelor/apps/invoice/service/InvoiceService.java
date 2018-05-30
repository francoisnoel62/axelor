package com.axelor.apps.invoice.service;

import java.math.BigDecimal;

import com.axelor.invoice.db.Invoice;
import com.axelor.sale.db.SaleOrder;

public interface InvoiceService {

	public BigDecimal calculateExTaxTotalPrice(Invoice inv);

	public BigDecimal calculateInTaxTotalPrice(Invoice inv);

	public Invoice cpyFromSaleToInvoice(SaleOrder sale);


}
