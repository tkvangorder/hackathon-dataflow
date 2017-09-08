package com.build.analytics.event.order;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ChargeStatus {

	A("Approved"),
	C("Cancelled"),
	E("Entered"),
	P("Processed");
	
	// allow unrecognized values, so we can ignore event types that have been
	// added upstream
	@JsonCreator
	public static ChargeStatus fromJsonValue(String jsonValue) {
		if (jsonValue != null) {
			try {
				return ChargeStatus.valueOf(jsonValue);
			} catch (IllegalArgumentException e) {
				return null;
			}
		}
		return null;
	}

	private String description;
	
	private ChargeStatus(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	

}
