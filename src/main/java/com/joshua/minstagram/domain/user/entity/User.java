package com.joshua.minstagram.domain.user.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter // TODO : Setter private 으로 static 메소드 변경
@SuperBuilder
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@DynamicUpdate
@Entity
public class User {

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

    private String gender;

    private String profileImage; // profile photo path + photo name

//    @OneToMany(mappedBy = "user")
//    @JsonIgnoreProperties({"user", "tags", "likes"})
//    private List<Image> images = new ArrayList<>();
//
}
