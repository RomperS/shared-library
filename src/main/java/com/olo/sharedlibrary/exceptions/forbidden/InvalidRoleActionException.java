package com.olo.sharedlibrary.exceptions.forbidden;

import com.olo.sharedlibrary.exceptions.SecurityException;

public class InvalidRoleActionException extends SecurityException {
    public InvalidRoleActionException(String message) {
        super("SecurityException: " + message);
    }

    public InvalidRoleActionException(String message, Throwable cause) {
        super("SecurityException: " + message, cause);
    }
}
