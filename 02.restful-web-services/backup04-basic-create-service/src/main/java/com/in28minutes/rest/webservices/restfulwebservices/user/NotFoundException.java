package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND) not Used
public class NotFoundException extends RuntimeException {
	public NotFoundException(String message) {
		super(message);
	}
}
