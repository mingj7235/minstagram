package com.joshua.minstagram.domain.user.service.core;

import com.joshua.minstagram.domain.user.entity.User;
import com.joshua.minstagram.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(final @NotNull User user) {
        userRepository.save(user);
    }

}
