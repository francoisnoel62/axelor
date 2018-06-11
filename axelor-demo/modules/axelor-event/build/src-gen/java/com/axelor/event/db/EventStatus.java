package com.axelor.event.db;

import java.util.Objects;

import com.axelor.db.ValueEnum;
import com.axelor.db.annotations.Widget;

public enum EventStatus implements ValueEnum<Integer> {

	@Widget(title = "Not started")
	NOT_STARTED(1),

	@Widget(title = "In progress")
	IN_PROGRESS(2),

	@Widget(title = "Completed")
	COMPLETED(3),

	@Widget(title = "Postponed")
	POSTPONED(4),

	@Widget(title = "Cancelled")
	CANCELLED(5);

	private final Integer value;

	private EventStatus(Integer value) {
		this.value = Objects.requireNonNull(value);
	}

	@Override
	public Integer getValue() {
		return value;
	}
}
