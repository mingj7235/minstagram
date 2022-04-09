package com.joshua.minstagram.domain.follow.service;

import com.joshua.minstagram.domain.follow.service.core.FollowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class FollowFacadeService {

    private final FollowService followService;
}
