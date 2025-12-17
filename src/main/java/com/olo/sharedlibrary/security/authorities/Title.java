package com.olo.sharedlibrary.security.authorities;

import com.olo.sharedlibrary.exceptions.value.InvalidPermissionValueException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Title {
    STANDARD(null),

    PRINCIPAL(Role.SUPER_ADMIN),

    SECRETARY(Role.ADMIN),
    LIBRARIAN(Role.ADMIN),
    COORDINATOR(Role.ADMIN),

    //Profes
    HOMEROOM_TEACHER(Role.TEACHER),
    DEPARTMENT_HEAD(Role.TEACHER),

    //Estudiantes
    GROUP_REPRESENTATIVE(Role.STUDENT),
    COMPTROLLER(Role.STUDENT),
    STUDENT_REPRESENTATIVE(Role.STUDENT),

    //Padres
    GUARDIAN(Role.PARENT),
    PARENTS_BOARD(Role.PARENT),

    //Conjero
    SCHOOL_COUNSELOR(Role.COUNSELOR),
    PSYCHOLOGIST(Role.COUNSELOR),
    SOCIAL_WORKER(Role.COUNSELOR);

    private final Role role;

    public static Title fromString(String title){
        try {
            return Title.valueOf(title.toUpperCase());
        }catch (IllegalArgumentException e){
            throw new InvalidPermissionValueException("Invalid title value");
        }
    }
}