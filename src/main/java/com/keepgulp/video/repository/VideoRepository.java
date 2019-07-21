package com.keepgulp.video.repository;

import com.keepgulp.video.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Integer> {

    VideoEntity findDistinctByVideoId(String vId);

    List<VideoEntity> findVideoEntitiesByUid(String uId);
}
