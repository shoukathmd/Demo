package com.microservice.service;

public class DemoException extends RuntimeException {
    static final long serialVersionUID = 1L;

    public DemoException() {
        super("User not authorized to the resource.");
    }

    public DemoException(String msg) {
        super(msg);
    }

}
