package com.keepgulp.video.service.impl;

import com.keepgulp.video.service.VideoParseService;

public class VideoFactory {
	public static VideoParseService getVideo(String type)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		if (type.indexOf("douyin.com") != -1 || type.indexOf("iesdouyin.com") != -1 ) {

			return DouyinParseServiceImpl.class.newInstance();

		} else if (type.indexOf("huoshan.com") != -1 )  {

			return HuoShanParseServiceImpl.class.newInstance();

		} else if (type.indexOf("kuaishou.com") != -1 || type.indexOf("gifshow.com") != -1 || type.indexOf("chenzhongtech.com") != -1) {

			return KuaiShouParseServiceImpl.class.newInstance();

		} else if (type.indexOf("pipix.com") != -1) {

			return PiPiXParseServiceImpl.class.newInstance();

		} else if (type.indexOf("weishi.qq.com")!= -1 ) {

			return WeiShiParseServiceImpl.class.newInstance();

		}else if (type.indexOf("izuiyou.com") != -1) {

			return ZuiYouParseServiceImpl.class.newInstance();

		} else {
			System.out.println("哎呀！找不到相应的实例化类啦！");
			return null;
		}

	}
}
