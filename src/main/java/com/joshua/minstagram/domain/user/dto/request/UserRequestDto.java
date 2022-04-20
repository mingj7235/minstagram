package com.joshua.minstagram.domain.user.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Getter
@NoArgsConstructor
public class UserRequestDto {

    @Getter
    @AllArgsConstructor
    @Valid
    public static class SignUp {

        private String name;

        private String phonenum;

    }

}
