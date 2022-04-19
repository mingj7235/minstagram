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

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        log.info("/auth/loginProc 요청 들어옴");
        User user = userRepository.findByUsername(username);

        MyUserDetail userDetail = null;


        if (user != null) {
            userDetail = new MyUserDetail();
            userDetail.setUser(user);
        } else {
            throw new UsernameNotFoundException("not found 'username' ");
        }

        return userDetail;
    }

}
