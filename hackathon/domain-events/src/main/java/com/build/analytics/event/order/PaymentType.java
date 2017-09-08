package com.build.analytics.event.order;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * We maintain the legacy integer value in our enumeration, but we will store the enum as the value in the database.
 * 
 * @author tyler.vangorder
 *
 */
public enum PaymentType {
	CREDIT_CARD(1),
	PAYPAL(2),
	GOOGLE_CHECKOUT(3),
	FORCESHIP(4),
	CHECK(5),
	WIRE_TRANSFER(6),
	AMAZON_MARKETPLACE(7),
	AMAZON_PAYMENTS(8),
	CHANNEL_ADVISOR(9),
	GOOGLE_WALLET(10),
	VME(11),
	MASTER_PASS(12),
	BLUE_TARP(13),
	PENDING_CREDIT_CARD(14),
	STORE_CREDIT(15);

	private final int intValue;

	private PaymentType(int intValue) {
		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}
	
	// allow unrecognized values, so we can ignore event types that have been
	// added upstream
	@JsonCreator
	public static PaymentType fromJsonValue(String jsonValue) {
		if (jsonValue != null) {
			try {
				return PaymentType.valueOf(jsonValue);
			} catch (IllegalArgumentException e) {
				return null;
			}
		}
		return null;
	}
}
