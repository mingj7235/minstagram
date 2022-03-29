package com.joshua.minstagram.domain.likes.enity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.joshua.minstagram.domain.images.entity.Image;
import com.joshua.minstagram.domain.user.entity.User;
import com.joshua.minstagram.global.base.BaseTime;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter //FIXME : private
@SuperBuilder
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@AllArgsConstructor (access = AccessLevel.PRIVATE)
public class Likes extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnoreProperties({"images", "password", "name", "website", "bio", "email", "gender", "createdDate", "updatedDate"})
    private User user; // id, username, profileImage 만 가져옴

    @ManyToOne
    @JoinColumn (name = "imageId")
    @JsonIgnoreProperties ({"tags", "user", "likesList"})
    private Image image; //

}
