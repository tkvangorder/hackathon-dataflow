package com.build.analytics.event.order;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ChargeType {
	CRED("Credit"),
	DEBT("Debit"),
	CRCH("Credit Change"),
	DECH("Debit Change");
	
	// allow unrecognized values, so we can ignore event types that have been
	// added upstream
	@JsonCreator
	public static ChargeType fromJsonValue(String jsonValue) {
		if (jsonValue != null) {
			try {
				return ChargeType.valueOf(jsonValue);
			} catch (IllegalArgumentException e) {
				return null;
			}
		}
		return null;
	}

	private String description;
	private ChargeType(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
}
