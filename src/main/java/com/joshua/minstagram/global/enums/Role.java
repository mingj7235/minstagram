package com.joshua.minstagram.global.enums;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Getter
public enum Role {

    EMPLOYEE,

    PAYMENT_VISOR,

    LEAVE_VISOR,

    SUPER_VISOR,

    OWNER;

    public static boolean contains(@NotBlank final String name) {
        return Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toList())
                .contains(name.toUpperCase());
    }

    public static Role of(@NotBlank final String name) {
        return Role.valueOf(name.toUpperCase(Locale.ROOT));
    }

    public static boolean isAllMatch(@NotBlank final String roles) {
        return Arrays.stream(roles.toUpperCase(Locale.ROOT).split(","))
                .allMatch(Role::contains);
    }

    public static List<Role> arrayValueOf(@NotBlank final String roles) {
        return Arrays.stream(roles.toUpperCase(Locale.ROOT).split(","))
                .map(Role::valueOf)
                .collect(Collectors.toUnmodifiableList());
    }

    public static List<Role> supervisorRoles() {
        return List.of(SUPER_VISOR, OWNER);
    }

    public boolean contains(@NotEmpty final Role[] roles) {
        return Arrays.stream(roles)
                .collect(Collectors.toList())
                .contains(this);
    }

}

