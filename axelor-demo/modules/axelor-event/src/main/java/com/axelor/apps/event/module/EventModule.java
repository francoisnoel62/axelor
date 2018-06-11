package com.axelor.apps.event.module;

import com.axelor.app.AxelorModule;
import com.axelor.apps.event.service.EventService;
import com.axelor.apps.event.service.EventServiceImpl;

public class EventModule extends AxelorModule {

	@Override
	protected void configure() {
		bind(EventService.class).to(EventServiceImpl.class);
		
	}

}
