package com.build.analytics.event;

import java.util.Date;

public abstract class StreamingDataEvent implements StreamingEvent {

	private DataEventType eventType; 
	private Date timestampEventCreated;
	
	public StreamingDataEvent() {		
	}
	
	public StreamingDataEvent(DataEventType eventType) {
		this.eventType = eventType;
	}
	
	public DataEventType getEventType() {
		return eventType;
	}

	public void setEventType(DataEventType eventType) {
		this.eventType = eventType;
	}

	public Date getTimestampEventCreated() {
		return this.timestampEventCreated;
	}

	public void setTimestampEventCreated(Date createdTimestamp) {
		this.timestampEventCreated = createdTimestamp;
	}

}
