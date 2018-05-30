package com.axelor.apps.accounting.module;

import com.axelor.app.AxelorModule;
import com.axelor.apps.accounting.service.AccountingService;
import com.axelor.apps.accounting.service.AccountingServiceImpl;

public class AccountingModule extends AxelorModule {

	@Override
	protected void configure() {
		bind(AccountingService.class).to(AccountingServiceImpl.class);
	}

}
