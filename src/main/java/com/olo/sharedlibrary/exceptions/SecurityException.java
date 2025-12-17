package com.olo.sharedlibrary.exceptions;

public class SecurityException extends RuntimeException {
    public SecurityException(String message) {
        super("SecurityException: " + message);
    }

    public SecurityException(String message, Throwable cause) {
        super("SecurityException: " + message, cause);
    }
}
