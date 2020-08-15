package com.account.app.model;

import lombok.Data;

@Data
public class ExceptionResponse{

	private String errorMessage;
	private String requestedUri;
}
