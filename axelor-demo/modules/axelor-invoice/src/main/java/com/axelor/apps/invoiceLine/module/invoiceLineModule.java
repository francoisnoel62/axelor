package com.axelor.apps.invoiceLine.module;

import com.axelor.app.AxelorModule;
import com.axelor.apps.invoiceLine.service.InvoiceLineService;
import com.axelor.apps.invoiceLine.service.InvoiceLineServiceImpl;

public class invoiceLineModule extends AxelorModule {

	@Override
	protected void configure() {
		bind(InvoiceLineService.class).to(InvoiceLineServiceImpl.class);
		
	}

}
