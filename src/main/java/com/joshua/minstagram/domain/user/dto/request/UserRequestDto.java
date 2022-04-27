package com.joshua.minstagram.domain.user.dto.request;

import com.joshua.minstagram.domain.user.enums.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Getter
@NoArgsConstructor
public class UserRequestDto {

    @Getter
    @NoArgsConstructor
    @Valid
    public static class SignUp {

        private String username;

        private String name;

        private String phonenum;

        private String website;

        private String bio;

        private Gender gender;

    }

}
