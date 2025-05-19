package com.me.project_management_api.exception;

public class UrlProjectAlreadyUsedException extends RuntimeException {

    public UrlProjectAlreadyUsedException(String message) {
        super(message);
    }
}
