package com.build.analytics.event.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.build.analytics.event.DataEventType;
import com.build.analytics.event.StreamingDataEvent;

public class OrderDataEvent extends StreamingDataEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long orderId;
	private Long customerId;
	private Long siteId;
	private Long storeId;
	private Long addressIdShipping;
	private Long couponId;
	private Date timestampPaymentReceived;
	private Date timestampOrderPlaced;
	private BigDecimal discountTotalAmount;
	private BigDecimal taxTotalAmount;
	private BigDecimal shippingTotalAmount;
	private String status;
	private String paymentMethod;
	private String transactionId;
	private String shippingMethod;
	private Long userIdPlacedBy;
	private Long userIdQuotedBy;
	private Boolean isWebOrder;
	private Boolean isGuestOrder;

	public OrderDataEvent() {
	}
	
	public OrderDataEvent(DataEventType eventType) {
		super(eventType);		
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

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getAddressIdShipping() {
		return addressIdShipping;
	}

	public void setAddressIdShipping(Long shippingAddressId) {
		this.addressIdShipping = shippingAddressId;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public Date getTimestampPaymentReceived() {
		return timestampPaymentReceived;
	}

	public void setTimestampPaymentReceived(Date orderDate) {
		this.timestampPaymentReceived = orderDate;
	}

	public Date getTimestampOrderPlaced() {
		return timestampOrderPlaced;
	}

	public void setTimestampOrderPlaced(Date placedDate) {
		this.timestampOrderPlaced = placedDate;
	}

	public BigDecimal getDiscountTotalAmount() {
		return discountTotalAmount;
	}

	public void setDiscountTotalAmount(BigDecimal discountTotal) {
		this.discountTotalAmount = discountTotal;
	}

	public BigDecimal getTaxTotalAmount() {
		return taxTotalAmount;
	}

	public void setTaxTotalAmount(BigDecimal taxTotal) {
		this.taxTotalAmount = taxTotal;
	}

	public BigDecimal getShippingTotalAmount() {
		return shippingTotalAmount;
	}

	public void setShippingTotalAmount(BigDecimal shippingTotal) {
		this.shippingTotalAmount = shippingTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public Boolean getIsWebOrder() {
		return isWebOrder;
	}

	public void setIsWebOrder(Boolean web) {
		this.isWebOrder = web;
	}

	public Long getUserIdPlacedBy() {
		return userIdPlacedBy;
	}

	public void setUserIdPlacedBy(Long userPlacedBy) {
		this.userIdPlacedBy = userPlacedBy;
	}

	public Long getUserIdQuotedBy() {
		return userIdQuotedBy;
	}

	public void setUserIdQuotedBy(Long userQuotedBy) {
		this.userIdQuotedBy = userQuotedBy;
	}

	public Boolean getIsGuestOrder() {
		return isGuestOrder;
	}

	public void setIsGuestOrder(Boolean guest) {
		this.isGuestOrder = guest;
	}

	public String getPartitionId() {
		return orderId == null?null:orderId.toString();
	}

}
