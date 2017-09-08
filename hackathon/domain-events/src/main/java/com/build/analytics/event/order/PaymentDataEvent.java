package com.build.analytics.event.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.build.analytics.event.DataEventType;
import com.build.analytics.event.StreamingDataEvent;

public class PaymentDataEvent extends StreamingDataEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long paymentId;
	private Long orderId;
	private Long customerId;
	private PaymentType paymentType;
	private BigDecimal paymentAmount;
	private Long addressIdBilling;
	private Date timestampRequested;
	private Date timestampReceived;

	public PaymentDataEvent() {
	}
	
	public PaymentDataEvent(DataEventType eventType) {
		super(eventType);
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal amount) {
		this.paymentAmount = amount;
	}

	public Long getAddressIdBilling() {
		return addressIdBilling;
	}

	public void setAddressIdBilling(Long addressId) {
		this.addressIdBilling = addressId;
	}

	public Date getTimestampRequested() {
		return timestampRequested;
	}

	public void setTimestampRequested(Date dateRequested) {
		this.timestampRequested = dateRequested;
	}

	public Date getTimestampReceived() {
		return timestampReceived;
	}

	public void setTimestampReceived(Date dateReceived) {
		this.timestampReceived = dateReceived;
	}

	public String getPartitionId() {
		return paymentId == null?null:paymentId.toString();
	}

}
