package com.build.analytics.event.customer;

import java.io.Serializable;
import java.util.Date;

import com.build.analytics.event.DataEventType;
import com.build.analytics.event.StreamingDataEvent;

public class CustomerDataEvent extends StreamingDataEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long customerId;
	private String userLogin;
	private String firstName;
	private String lastName;
	private String email;
	private String signUpSite;
	private String referredFrom;
	private Boolean isSubscriber;
	private Boolean isMobile;
	private Boolean isPro;
	private Boolean isGuest;
	private Boolean isLowRisk;
	private Boolean isHighRisk;
	private Long pricebookId;
	private String pricebookName;
	private Date timestampRegistered;
	
	
	public CustomerDataEvent() {
	}
	
	public CustomerDataEvent(DataEventType eventType) {
		super(eventType);		
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long id) {
		this.customerId = id;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userName) {
		this.userLogin = userName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSignUpSite() {
		return signUpSite;
	}

	public void setSignUpSite(String signUpSite) {
		this.signUpSite = signUpSite;
	}

	public String getReferredFrom() {
		return referredFrom;
	}

	public void setReferredFrom(String referredFrom) {
		this.referredFrom = referredFrom;
	}

	public Boolean getIsSubscriber() {
		return isSubscriber;
	}

	public void setIsSubscriber(Boolean isSubscriber) {
		this.isSubscriber = isSubscriber;
	}

	public Boolean getIsMobile() {
		return isMobile;
	}

	public void setIsMobile(Boolean isMobile) {
		this.isMobile = isMobile;
	}

	public Boolean getIsPro() {
		return isPro;
	}

	public void setIsPro(Boolean isPro) {
		this.isPro = isPro;
	}

	public Boolean getIsGuest() {
		return isGuest;
	}

	public void setIsGuest(Boolean isGuest) {
		this.isGuest = isGuest;
	}

	public Boolean getIsLowRisk() {
		return isLowRisk;
	}

	public void setIsLowRisk(Boolean isLowRisk) {
		this.isLowRisk = isLowRisk;
	}

	public Boolean getIsHighRisk() {
		return isHighRisk;
	}

	public void setIsHighRisk(Boolean isHighRisk) {
		this.isHighRisk = isHighRisk;
	}

	public Long getPricebookId() {
		return pricebookId;
	}

	public void setPricebookId(Long pricebookId) {
		this.pricebookId = pricebookId;
	}

	public String getPricebookName() {
		return pricebookName;
	}

	public void setPricebookName(String pricebookName) {
		this.pricebookName = pricebookName;
	}

	public String getPartitionId() {
		return customerId == null?null:customerId.toString();
	}

	public Date getTimestampRegistered() {
		return timestampRegistered;
	}

	public void setTimestampRegistered(Date timestampRegistered) {
		this.timestampRegistered = timestampRegistered;
	}

}
