package com.olo.sharedlibrary.exceptions.forbidden;

import com.olo.sharedlibrary.exceptions.SecurityException;

public class InvalidTitleException extends SecurityException {
    public InvalidTitleException(String message) {
        super(message);
    }

    public InvalidTitleException(String message, Throwable cause) {
        super(message, cause);
    }
}
