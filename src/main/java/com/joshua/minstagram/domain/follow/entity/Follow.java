package com.joshua.minstagram.domain.follow.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.joshua.minstagram.domain.user.entity.User;
import com.joshua.minstagram.global.base.BaseTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter //FIXME : setter private
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Follow extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;

    @Transient
//    private boolean f4f; //맞팔 여부
    private boolean followState;

    // 중간 테이블 생성
    // fromUser가 toUser를 following 함.
    // toUser를 fromUser가 follower함
    @ManyToOne
    @JoinColumn (name = "fromUserId")
    @JsonIgnoreProperties({"images"})
    private User fromUser;

    @ManyToOne
    @JoinColumn (name = "toUserId")
    @JsonIgnoreProperties ({"images"})
    private User toUser;

}
