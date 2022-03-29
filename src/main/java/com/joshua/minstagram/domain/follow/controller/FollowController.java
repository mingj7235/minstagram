package com.joshua.minstagram.domain.follow.controller;

import com.joshua.minstagram.domain.follow.entity.Follow;
import com.joshua.minstagram.domain.follow.repository.FollowRepository;
import com.joshua.minstagram.domain.user.entity.User;
import com.joshua.minstagram.domain.user.repository.UserRepository;
import com.joshua.minstagram.global.auth.MyUserDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping ("/follow")
@RequiredArgsConstructor
public class FollowController {

    private final UserRepository userRepository;

    private final FollowRepository followRepository;

    @PostMapping ("/{id}")
    public @ResponseBody String follow (@AuthenticationPrincipal MyUserDetail userDetail,
                                        @PathVariable Long id) {
        User fromUser = userDetail.getUser();

        User toUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found user"));

        Follow follow = new Follow();
        follow.setFromUser(fromUser);
        follow.setToUser(toUser);

        followRepository.save(follow);

        return "ok";
    }

    @DeleteMapping ("/{id}")
    public @ResponseBody String unFollow (@AuthenticationPrincipal MyUserDetail userDetail,
                                          @PathVariable Long id) {
        User fromUser = userDetail.getUser();

        User toUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found user"));

        followRepository.deleteByFromUserIdAndToUserId(fromUser.getId(), toUser.getId());

        List<Follow> follows = followRepository.findAll();

        return "ok";
    }

    @GetMapping ("/follower/{id}")
    public String followFollower (@PathVariable Long id) {

        return "follow/follow";
    }

    @GetMapping ("/follow/{id}")
    public String followFollow (@PathVariable Long id) {

        return "follow/follow";
    }
}