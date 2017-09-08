package com.build.analytics.event.customer;

import java.io.Serializable;

import com.build.analytics.event.DataEventType;
import com.build.analytics.event.StreamingDataEvent;


public class CustomerAddressDataEvent extends StreamingDataEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long addressId;
	private Long customerId;
	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String stateCode;
	private String stateName;
	private String postalCode;
	private String countryCode;
	private String countryName;
	private String phone;
	private Boolean isActive;
	private Boolean isDefault;
	
	public CustomerAddressDataEvent() {
	}
		
	public CustomerAddressDataEvent(DataEventType eventType) {		
		super(eventType);
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String address) {
		this.addressLine1 = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String state) {
		this.stateName = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String country) {
		this.countryName = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getPartitionId() {
		return customerId == null?null:customerId.toString();
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

}
