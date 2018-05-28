package com.axelor.apps.invoiceLine.service;

import java.math.BigDecimal;

import com.axelor.invoice.db.InvoiceLine;

public class InvoiceLineServiceImpl implements InvoiceLineService {

	@Override
	public String setProductDescription(InvoiceLine invLine) {
		return invLine.getProduct().getDescription();

	}

	@Override
	public BigDecimal setProductExTaxPrice(InvoiceLine invLine) {
		return invLine.getProduct().getExTaxPrice();

	}

	@Override
	public BigDecimal setExSubTotalPrice(InvoiceLine invLine) {
		return invLine.getProduct().getExTaxPrice().multiply(invLine.getQty());
	}

	@Override
	public BigDecimal setinSubTotalPrice(InvoiceLine invLine) {
		return setExSubTotalPrice(invLine).multiply(invLine.getTax().add(BigDecimal.ONE));
	}
	
	@Override
	public String setProductAccountingAccount(InvoiceLine invLine) {
		return invLine.getProduct().getAccountingAccount();
	}
	

}
