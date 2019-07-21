package com.keepgulp.video.service;

import com.keepgulp.video.entity.CommentEntity;
import com.keepgulp.video.entity.UserEntity;
import com.keepgulp.video.entity.VideoEntity;

import java.util.List;

public interface StorageService {

    UserEntity save(UserEntity entity);

    void saveUsersBatch(List<UserEntity> users);

    UserEntity findUserByUId(String uId);

    UserEntity findUserByDouyinId(String douyinId);

    VideoEntity save(VideoEntity entity);

    void saveVideosBatch(List<VideoEntity> videos);

    VideoEntity findVideoByVId(String vId);

    CommentEntity save(CommentEntity entity);

    void saveCommentsBatch(List<CommentEntity> comments);
}
