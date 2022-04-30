package com.joshua.minstagram.domain.user.service.core;

import com.joshua.minstagram.domain.user.dto.request.UserRequestDto;
import com.joshua.minstagram.domain.user.entity.User;
import com.joshua.minstagram.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(final @NotNull UserRequestDto.SignUp signUpRequest) {
        userRepository.save(User.toEntity(signUpRequest));
    }

    public boolean existByUsername (final @NotBlank String username) {
        return userRepository.existsByUsername(username);
    }

    public User findByUsername(final @NotBlank String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(final @NotNull Long id) {
        return userRepository.findById(id);
    }

}
