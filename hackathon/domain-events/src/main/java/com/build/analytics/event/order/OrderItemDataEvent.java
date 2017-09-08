package com.build.analytics.event.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.build.analytics.event.DataEventType;
import com.build.analytics.event.StreamingDataEvent;

public class OrderItemDataEvent extends StreamingDataEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long orderItemId;
	private String legacyItemId;
	private Long orderId;
	private Date timestampOrdered;
	private Long productVariationId; //productUniqueId
	private String productCode;
	private String productManufacturerName;
	private String productVariationDescription;
	private BigDecimal unitPrice;
	private Integer quantity;

	public OrderItemDataEvent() {
	}
	public OrderItemDataEvent(DataEventType eventType) {		
		super(eventType);
	}

	public String getLegacyItemId() {
		return legacyItemId;
	}

	public void setLegacyItemId(String orderItemId) {
		this.legacyItemId = orderItemId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getTimestampOrdered() {
		return timestampOrdered;
	}

	public void setTimestampOrdered(Date orderDate) {
		this.timestampOrdered = orderDate;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductManufacturerName() {
		return productManufacturerName;
	}

	public void setProductManufacturerName(String productManufacturer) {
		this.productManufacturerName = productManufacturer;
	}

	public String getProductVariationDescription() {
		return productVariationDescription;
	}

	public void setProductVariationDescription(String productVariationName) {
		this.productVariationDescription = productVariationName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPartitionId() {
		return orderId==null?null:orderId.toString();
	}

	public Long getProductVariationId() {
		return productVariationId;
	}

	public void setProductVariationId(Long productUniqueId) {
		this.productVariationId = productUniqueId;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

}
