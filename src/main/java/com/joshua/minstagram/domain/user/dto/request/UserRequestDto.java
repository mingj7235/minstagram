package com.joshua.minstagram.domain.user.dto.request;

import com.joshua.minstagram.domain.user.enums.Gender;
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

        private String password;

        private String name;

        private String website;

        private String bio;

        private String email;

        private String phone;

        private Gender gender;

        private String profileImage;

    }

}
