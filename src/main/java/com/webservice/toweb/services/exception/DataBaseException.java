package com.webservice.toweb.services.exception;

public class DataBaseException extends RuntimeException{
    public DataBaseException(String error) {
        super(error);
    }
}
