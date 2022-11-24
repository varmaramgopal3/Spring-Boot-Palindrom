package com.palindrome.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * @author RamGopalVarma
 *
 */
/**
 * @author SivajiSangati
 *
 */
public class ResponseMessage {
	private HttpStatus status;
	private String message;
	private List<String> errors;

	/**
	 * Default Constructor
	 */
	public ResponseMessage() {

	}

	/**
	 * @param status
	 * @param message
	 * @param errors
	 * Parameterized Constructor
	 */
	public ResponseMessage(HttpStatus status, String message, List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	/**
	 * @param status
	 * @param message
	 * @param error
	 * Parameterized Constructor
	 */
	public ResponseMessage(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}

	/**
	 * @return status
	 */
	public HttpStatus getStatus() {
		return status;
	}
	/**
	 * @param status
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * @param errors
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
