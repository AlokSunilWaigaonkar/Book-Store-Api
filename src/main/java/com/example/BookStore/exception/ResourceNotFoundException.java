package com.example.BookStore.exception;

/**
 * Exception thrown when requested resource not found in System.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Construct a new ResourceNotFoundException with specified message.
     * @param message the message describing the exception.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
