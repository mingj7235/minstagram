package com.joshua.minstagram.domain.user.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.joshua.minstagram.domain.images.entity.Image;
import com.joshua.minstagram.domain.user.dto.request.UserRequestDto;
import com.joshua.minstagram.domain.user.enums.Gender;
import com.joshua.minstagram.global.base.BaseTime;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter // TODO : Setter private 으로 static 메소드 변경
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@DynamicUpdate
@Builder
@Entity
public class User extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private String name;

    private String website;

    private String bio;

    private String email;

    private String phone;

    @Enumerated (EnumType.STRING)
    private Gender gender;

    private String profileImage; // profile photo path + photo name

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user", "tags", "likes"})
    private List<Image> images = new ArrayList<>();

    public static User toEntity (final @NotNull UserRequestDto.SignUp signUpRequest) {
        return User.builder()
                .username(signUpRequest.getUsername())
                .name(signUpRequest.getName())
                .gender(signUpRequest.getGender())
                .build();
    }

}
