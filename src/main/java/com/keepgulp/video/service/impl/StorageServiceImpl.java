package com.keepgulp.video.service.impl;

import com.keepgulp.video.entity.CommentEntity;
import com.keepgulp.video.entity.UserEntity;
import com.keepgulp.video.entity.VideoEntity;
import com.keepgulp.video.repository.CommentRepository;
import com.keepgulp.video.repository.UserRepository;
import com.keepgulp.video.repository.VideoRepository;
import com.keepgulp.video.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public UserEntity save(UserEntity entity) {
        return userRepository.save(entity);
    }

    @Override
    public void saveUsersBatch(List<UserEntity> users) {
        userRepository.saveAll(users);
    }

    @Override
    public UserEntity findUserByUId(String uId) {
        return null;
    }

    @Override
    public UserEntity findUserByDouyinId(String douyinId) {
        return null;
    }

    @Override
    public VideoEntity save(VideoEntity entity) {
        return videoRepository.save(entity);
    }

    @Override
    public void saveVideosBatch(List<VideoEntity> videos) {
        videoRepository.saveAll(videos);
    }

    @Override
    public VideoEntity findVideoByVId(String vId) {
        return null;
    }

    @Override
    public CommentEntity save(CommentEntity entity) {
        return commentRepository.save(entity);
    }

    @Override
    public void saveCommentsBatch(List<CommentEntity> comments) {
        commentRepository.saveAll(comments);
    }
}
