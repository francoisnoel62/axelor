package com.axelor.apps.event.service;

import java.time.Duration;

import com.axelor.event.db.Event;

public class EventServiceImpl implements EventService {

	@Override
	public int calculateDuration(Event event) {
		if(event.getEnd_time() == null || event.getStart_time() == null) { return 0;}
		return (int) Duration.between(event.getStart_time(), event.getEnd_time()).getSeconds();		
	}



	
}
