package com.mindtree.CMS.model;

import lombok.Data;

@Data
public class ApiSuccessResponse {

	private String message;

	private String httpStatus;

	private int httpStatusCode;

	private Object body;

	private boolean success;

	private boolean error;

}
