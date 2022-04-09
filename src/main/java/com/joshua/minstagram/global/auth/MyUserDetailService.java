package com.joshua.minstagram.global.auth;

import com.joshua.minstagram.domain.user.entity.User;
import com.joshua.minstagram.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    // security /auth/loginProc Post 요청이 들어올 때 실행됨
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        log.info("/auth/loginProc 요청 들어옴");
        User user = userRepository.findByUsername(username);

        MyUserDetail userDetail = null;

        //Redis JWT 토큰을 여기서 하면 되지않을까?

        if (user != null) {
            userDetail = new MyUserDetail();
            userDetail.setUser(user);
        } else {
            throw new UsernameNotFoundException("not found 'username' ");
        }

        return userDetail;
    }

}
