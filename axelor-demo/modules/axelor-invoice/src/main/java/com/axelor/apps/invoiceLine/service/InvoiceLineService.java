package com.axelor.apps.invoiceLine.service;

import java.math.BigDecimal;

import com.axelor.invoice.db.InvoiceLine;

public interface InvoiceLineService {
	
	public String setProductDescription(InvoiceLine invLine);
	public BigDecimal setProductExTaxPrice(InvoiceLine invLine);
	public BigDecimal setExSubTotalPrice(InvoiceLine invLine);
	public BigDecimal setInSubTotalPrice(InvoiceLine invLine);
	public String setProductAccountingAccount(InvoiceLine invLine);

}
