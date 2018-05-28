package com.axelor.invoice.db;

import java.util.Objects;

import com.axelor.db.ValueEnum;
import com.axelor.db.annotations.Widget;

public enum StatusEnum implements ValueEnum<Integer> {

	@Widget(title = "Draft")
	DRAFT(1),

	@Widget(title = "Validated")
	VALIDATED(2);

	private final Integer value;

	private StatusEnum(Integer value) {
		this.value = Objects.requireNonNull(value);
	}

	@Override
	public Integer getValue() {
		return value;
	}
}
