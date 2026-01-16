package com.kata.springmvc.exception;

/**
 * Thrown when an operation requires an existing User, but it cannot be found.
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
