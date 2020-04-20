package com.mindtree.CMS.model;

import lombok.Data;

@Data
public class ApiErrorResponse {

	private String message;

	private Object httpStatus;

	private int httpStatusCode;

	private boolean success;

	private boolean error;

	private Object cause;

	private Object exceptionMessage;

}
