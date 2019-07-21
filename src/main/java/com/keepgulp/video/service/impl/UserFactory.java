package com.keepgulp.video.service.impl;

import com.keepgulp.common.constants.AppType;
import com.keepgulp.video.service.UserInfoFetchService;

public class UserFactory {
	public static UserInfoFetchService getUser(AppType type)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		switch(type) {
			case DOUYIN:
				return DouyinUserInfoFetchServiceImpl.class.newInstance();
			case KUAISHOU:
				return KuaiShouUserInfoFetchServiceImpl.class.newInstance();
		}
		return null;
	}
}
