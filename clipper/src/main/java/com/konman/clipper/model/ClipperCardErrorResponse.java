package com.konman.clipper.model;

public class ClipperCardErrorResponse {
	
	// Literals
	private int status;
	private String message;
	private long timestamp;
	
	// Constructors
	public ClipperCardErrorResponse() {
		
	}

	public ClipperCardErrorResponse(int status, String message, long timestamp) {
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}
	
	// Generate Getters and Setters

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	// Generate toString
	@Override
	public String toString() {
		return "ClipperCardErrorResponse [status=" + status + ", message=" + message + ", timestamp=" + timestamp + "]";
	}
	
}
