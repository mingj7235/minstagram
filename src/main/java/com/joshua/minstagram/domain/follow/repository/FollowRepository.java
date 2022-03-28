package com.joshua.minstagram.domain.follow.repository;

import com.joshua.minstagram.domain.follow.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    @Transactional
    void deleteByFromUserIdAndToUserId (Long fromUserId, Long toUserId);

    int countByFromUserIdAndToUserId (Long fromUserId, Long toUserId);

    List<Follow> findByFromUserId (Long fromUserId);

    List<Follow> findByToUserId (Long toUserId);

}
