package com.palindrome.model;

import java.util.Date;

/**
 * @author RamGopalVarma
 *
 */
public class ErrorDetails {

	private Date timestamp;
	private String message;
	private String details;

	/**
	 * Default Constructor
	 */
	public ErrorDetails() {

	}

	/**
	 * @param timestamp
	 * @param message
	 * @param details
	 */
	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	/**
	 * @return timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param details
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	
}
