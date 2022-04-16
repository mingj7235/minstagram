package com.joshua.minstagram.global.annotation;

import com.joshua.minstagram.global.enums.Role;

import java.lang.annotation.*;

import static com.joshua.minstagram.global.enums.Role.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthRequired {

    Role[] roles() default {EMPLOYEE, PAYMENT_VISOR, LEAVE_VISOR, SUPER_VISOR, OWNER};

    boolean without() default false;

}
