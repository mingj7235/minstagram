package com.joshua.minstagram.domain.user.service;

import com.joshua.minstagram.domain.user.entity.User;
import com.joshua.minstagram.domain.user.service.core.UserService;
import com.joshua.minstagram.global.config.EncodeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserSignupFacadeService {

    private final UserService userService;

    public void signup(final @NotNull User user) {
        String rawPassword = user.getPassword();
        String encPassword = EncodeUtils.encode(rawPassword);
        user.setPassword(encPassword); //FIXME : setter -> private method
        userService.save(user); // FIXME : layer 분리

    }

}
