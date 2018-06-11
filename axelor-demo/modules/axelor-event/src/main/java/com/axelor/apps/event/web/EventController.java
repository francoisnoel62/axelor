package com.axelor.apps.event.web;

import com.axelor.apps.event.service.EventService;
import com.axelor.event.db.Event;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

public class EventController {

	@Inject
	protected EventService eventService;

	public void calculDurationBetweenEndTimeAndStartTimefromAnEvent(ActionRequest req, ActionResponse res) {

		// On recupere le contexte de la vue
		Event event = req.getContext().asType(Event.class);

		// On utilise la mathode necessaire du service sur le contexte recupéré
		int duration = eventService.calculateDuration(event);

		// On renvoie le resultat du traitement a travers la reponse
		res.setValue("duration", duration);

	}

}
