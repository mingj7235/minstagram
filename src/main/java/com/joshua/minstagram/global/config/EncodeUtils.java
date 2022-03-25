package com.joshua.minstagram.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;

@Configuration
@RequiredArgsConstructor
public class EncodeUtils implements InitializingBean {

    private static PasswordEncoder encoder;

    private final PasswordEncoder beanEncoder;

    public static String encode(final @NotBlank String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public static boolean isNotMatches(final @NotBlank String rawPassword,
                                       final @NotBlank String encodePassword) {
        return !encoder.matches(rawPassword, encodePassword);
    }

    @Override
    public void afterPropertiesSet() {
        encoder = this.beanEncoder;
    }

}
