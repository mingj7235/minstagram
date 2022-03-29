package com.joshua.minstagram.domain.images.repository;

import com.joshua.minstagram.domain.images.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
