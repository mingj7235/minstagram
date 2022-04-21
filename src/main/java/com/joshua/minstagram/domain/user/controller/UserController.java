package com.joshua.minstagram.domain.user.controller;

import com.joshua.minstagram.domain.follow.repository.FollowRepository;
import com.joshua.minstagram.domain.follow.service.FollowFacadeService;
import com.joshua.minstagram.domain.user.dto.request.UserRequestDto;
import com.joshua.minstagram.domain.user.entity.User;
import com.joshua.minstagram.domain.user.repository.UserRepository;
import com.joshua.minstagram.domain.user.service.UserSignupFacadeService;
import com.joshua.minstagram.global.auth.MyUserDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserSignupFacadeService userSignupFacadeService;

    private final FollowFacadeService followFacadeService;

    private final UserRepository userRepository;

    private final FollowRepository followRepository;

    @GetMapping("/auth/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/auth/join")
    public String authJoin(final @NotNull Model model) {

        model.addAttribute(new UserRequestDto.SignUp());
        return "auth/join";
    }

    @PostMapping("/auth/joinProc")
    public String authJoinProc(User user) {
        userSignupFacadeService.signup(user);
        return "redirect:/auth/login";
    }

    @GetMapping("/user/{id}")
    public String profile(@AuthenticationPrincipal MyUserDetail userDetail,
                          @PathVariable Long id,
                          Model model) {
        User owner = userRepository.findByUsername(userDetail.getUsername());
        model.addAttribute("owner", owner);

        /**
         *   1. imageCount
         *   2. followerCount
         *   3. followingCount
         *   4. User 오브젝트 (Image (likeCount) 컬렉션)
         *   5. followCheck 팔로우 유무 (1 팔로우, 1이 아니면 언팔로우)
         */

        //4. User 오브젝트
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found user"));

        model.addAttribute("user", user);

        //5. followCheck (팔로우 유무 -> 1이면 팔로우, 아니면 언팔) FIXME : 이부분 변경
        User principal = userDetail.getUser();

        int followCheck = followRepository.countByFromUserIdAndToUserId(principal.getId(), id);

        model.addAttribute("followCheck", followCheck);

        return "user/profile";
    }

    @GetMapping ("/user/edit/{id}")
    public String userEdit (@PathVariable Long id) {

        return "user/profile_edit";
    }
}
