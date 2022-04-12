package com.joshua.minstagram.domain.user.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Getter
@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class UserRequestDto {

    @Getter
    @AllArgsConstructor (access = AccessLevel.PRIVATE)
    @Valid
    public static class SignUp {

    }

}
