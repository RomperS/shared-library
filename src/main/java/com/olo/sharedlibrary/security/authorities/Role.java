package com.olo.sharedlibrary.security.authorities;

import com.olo.sharedlibrary.exceptions.value.InvalidPermissionValueException;

public enum Role {
    ADMIN,
    TEACHER,
    STUDENT,
    PARENT,
    SUPER_ADMIN,
    COUNSELOR;

    public static Role fromString(String role){
        try {
            return Role.valueOf(role.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new InvalidPermissionValueException("Invalid role value");
        }
    }
}