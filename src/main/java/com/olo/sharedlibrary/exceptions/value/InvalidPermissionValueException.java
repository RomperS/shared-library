package com.olo.sharedlibrary.exceptions.value;

public class InvalidPermissionValueException extends SecurityException {
    public InvalidPermissionValueException(String message) {
        super("SecurityException: " + message);
    }

    public InvalidPermissionValueException(String message, Throwable cause) {
        super("SecurityException: " + message, cause);
    }
}
