package com.axelor.apps.invoice.module;

import com.axelor.app.AxelorModule;
import com.axelor.apps.invoice.service.InvoiceService;
import com.axelor.apps.invoice.service.InvoiceServiceImpl;

public class InvoiceModule extends AxelorModule {

	@Override
	protected void configure() {
		bind(InvoiceService.class).to(InvoiceServiceImpl.class);
		
	}

}
