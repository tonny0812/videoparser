package com.keepgulp.video.repository;

import com.keepgulp.video.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findUserEntityByUid(String uId);

    UserEntity findDistinctByDouyinId(String douyinId);
}
