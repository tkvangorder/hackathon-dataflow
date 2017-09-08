package com.build.analytics.event.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.build.analytics.event.DataEventType;
import com.build.analytics.event.StreamingDataEvent;

public class ChargeDataEvent extends StreamingDataEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long chargeId;
	private Long orderId;
	private Long paymentId;
	private Long poNumber;
	private ChargeStatus chargeStatus;
	private ChargeType chargeType;
	private BigDecimal chargeAmount;
	private BigDecimal taxAmount;
	private BigDecimal shippingAmount;
	private Date timestampRequested;
	private Date timestampIssued;
	private String nameRequestedBy;
	private String nameApprovedBy;
	private String reasonNotes;
	private String reasonClass;
	private String siteName;

	public ChargeDataEvent() {
	}
	public ChargeDataEvent(DataEventType eventType) {
		super(eventType);
	}

	public Long getChargeId() {
		return chargeId;
	}

	public void setChargeId(Long chargeId) {
		this.chargeId = chargeId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(BigDecimal amount) {
		this.chargeAmount = amount;
	}

	public ChargeStatus getChargeStatus() {
		return chargeStatus;
	}

	public void setChargeStatus(ChargeStatus chargeStatus) {
		this.chargeStatus = chargeStatus;
	}

	public Date getTimestampRequested() {
		return timestampRequested;
	}

	public void setTimestampRequested(Date dateRequested) {
		this.timestampRequested = dateRequested;
	}

	public Date getTimestampIssued() {
		return timestampIssued;
	}

	public void setTimestampIssued(Date dateIssued) {
		this.timestampIssued = dateIssued;
	}

	public String getNameRequestedBy() {
		return nameRequestedBy;
	}

	public void setNameRequestedBy(String requestedBy) {
		this.nameRequestedBy = requestedBy;
	}

	public String getNameApprovedBy() {
		return nameApprovedBy;
	}

	public void setNameApprovedBy(String approvedBy) {
		this.nameApprovedBy = approvedBy;
	}

	public ChargeType getChargeType() {
		return chargeType;
	}

	public void setChargeType(ChargeType type) {
		this.chargeType = type;
	}

	public String getReasonNotes() {
		return reasonNotes;
	}

	public void setReasonNotes(String reason) {
		this.reasonNotes = reason;
	}

	public String getReasonClass() {
		return reasonClass;
	}

	public void setReasonClass(String reasonClass) {
		this.reasonClass = reasonClass;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal tax) {
		this.taxAmount = tax;
	}

	public BigDecimal getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(BigDecimal shipping) {
		this.shippingAmount = shipping;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(Long poNumber) {
		this.poNumber = poNumber;
	}

	public String getPartitionId() {
		return chargeId == null?null:chargeId.toString();
	}
		
}
