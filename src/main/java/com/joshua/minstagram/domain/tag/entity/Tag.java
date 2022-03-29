package com.joshua.minstagram.domain.tag.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.joshua.minstagram.domain.images.entity.Image;
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
public class Tag extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "imageId")
    @JsonBackReference
    private Image image;

}
