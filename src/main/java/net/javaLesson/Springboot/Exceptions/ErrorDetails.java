package net.javaLesson.Springboot.Exceptions;

import java.util.Date;

public class ErrorDetails {
	private Date timesstamp;
	private String message;
	private String details;
	
	
	public ErrorDetails(Date timesstamp, String message, String details) {
		super();
		this.timesstamp = timesstamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimesstamp() {
		return timesstamp;
	}
	public void setTimesstamp(Date timesstamp) {
		this.timesstamp = timesstamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
