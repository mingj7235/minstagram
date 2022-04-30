package com.joshua.minstagram.domain.user.service;

import com.joshua.minstagram.domain.user.dto.request.UserRequestDto;
import com.joshua.minstagram.domain.user.service.core.UserService;
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

    public void signup(final @NotNull UserRequestDto.SignUp signUpRequest) {

        if (userService.existByUsername(signUpRequest.getUsername()))
            throw new IllegalArgumentException("exist username already");

        userService.save(signUpRequest);
    }
}
