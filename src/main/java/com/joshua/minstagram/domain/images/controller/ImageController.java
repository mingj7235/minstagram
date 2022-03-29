package com.joshua.minstagram.domain.images.controller;

import com.joshua.minstagram.domain.user.entity.User;
import com.joshua.minstagram.domain.user.repository.UserRepository;
import com.joshua.minstagram.global.auth.MyUserDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ImageController {

    private final UserRepository userRepository;

    @GetMapping ({"/", "/image/feed"})
    public String imageFeed (@AuthenticationPrincipal MyUserDetail userDetail, Model model) {
        log.info("username : {}", userDetail.getUsername());

        User owner = userRepository.findByUsername(userDetail.getUsername());

        model.addAttribute("owner", owner);

        return "image/feed";
    }
}
