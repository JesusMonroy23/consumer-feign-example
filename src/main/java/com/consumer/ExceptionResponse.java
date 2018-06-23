package com.consumer;

import java.util.Date;

public class ExceptionResponse {
	private Date date;
	private String message;
	private String moreInfo;
	
	public ExceptionResponse(Date date, String message, String moreInfo) {
		super();
		this.date = date;
		this.message = message;
		this.moreInfo = moreInfo;
	}
	
	public ExceptionResponse() {

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [date=" + date + ", message=" + message + ", moreInfo=" + moreInfo + "]";
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	
	
	
	

}
