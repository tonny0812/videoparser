package com.keepgulp.video.service;

import com.keepgulp.common.constants.AppType;
import com.keepgulp.video.model.UserModel;

public interface UserInfoFetchService {

    UserModel fetchUserInfo(String uId, AppType appType);
}
