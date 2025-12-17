package com.olo.sharedlibrary.exceptions;

public class EventException extends RuntimeException {
    public EventException(String message) {
        super("SecurityException: " + message);
    }

    public EventException(String message, Throwable cause) {
        super("SecurityException: " + message, cause);
    }
}
