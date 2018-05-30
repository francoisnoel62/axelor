package com.axelor.sale.db;

import java.util.Objects;

import com.axelor.db.ValueEnum;
import com.axelor.db.annotations.Widget;

public enum StatusEnum2 implements ValueEnum<Integer> {

	@Widget(title = "Draft")
	DRAFT(1),

	@Widget(title = "Validated")
	VALIDATED(2),

	@Widget(title = "Invoiced")
	INVOICED(3);

	private final Integer value;

	private StatusEnum2(Integer value) {
		this.value = Objects.requireNonNull(value);
	}

	@Override
	public Integer getValue() {
		return value;
	}
}
