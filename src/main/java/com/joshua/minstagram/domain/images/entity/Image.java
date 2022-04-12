package com.joshua.minstagram.domain.images.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.joshua.minstagram.domain.user.entity.User;
import com.joshua.minstagram.global.base.BaseTime;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.aspectj.lang.annotation.AfterReturning;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@AllArgsConstructor (access = AccessLevel.PRIVATE)
@Entity
public class Image extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;

    private String location; // 사진 위치

    private String caption; // 사진 설명

    private String postImage; // 포스팅할 사진의 경로 + 이름

    @Transient //DB 영향 가지 않도록 함
    private Long likeCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "userId")
    @JsonIgnoreProperties({"password", "images"})
    private User user;

//    @OneToMany (mappedBy = "image")
//    private List<Likes> likesList = new ArrayList<>();
//
//    @OneToMany (mappedBy = "image")
//    @JsonManagedReference
//    private List<Tag> tags = new ArrayList<>();

}
