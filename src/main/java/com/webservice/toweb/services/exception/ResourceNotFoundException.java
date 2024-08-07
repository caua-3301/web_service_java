package com.webservice.toweb.services.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id) {
        super("Resource with id " + id + " dont exist");
    }
}
