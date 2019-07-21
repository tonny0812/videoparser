package com.keepgulp.video.service.impl;

import com.keepgulp.common.constants.AppType;
import com.keepgulp.video.model.UserModel;
import com.keepgulp.video.service.UserInfoFetchService;
import org.springframework.stereotype.Service;

@Service
public class KuaiShouUserInfoFetchServiceImpl implements UserInfoFetchService {
    @Override
    public UserModel fetchUserInfo(String uId, AppType appType) {
        return null;
    }
}
