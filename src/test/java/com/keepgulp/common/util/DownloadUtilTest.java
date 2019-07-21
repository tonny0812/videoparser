package com.keepgulp.common.util;

import com.keepgulp.video.model.VideoModel;
import com.keepgulp.video.service.VideoService;
import com.keepgulp.video.service.impl.DouyinServiceImpl;
import com.keepgulp.video.service.impl.VideoFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DownloadUtilTest {

    @Test
    public void downloadVideo() throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        String rootDir = Test.class.getClassLoader().getResource("").getPath();
        String videosDir = rootDir + "/videos";
        List<String> urlList = Arrays.asList("http://v.douyin.com/BWQAk1",
                "http://m.chenzhongtech.com/s/mhn5haAq/");

        for(String url : urlList) {
            VideoService videoService = VideoFactory.getVideo(url);
            VideoModel videoModel = videoService.parseUrl(url);
            String fileName = videosDir + "/" + videoModel.getName().trim() + ".mp4";
            DownloadUtil.downloadVideo(videoModel.getPlayAddr(), fileName);
        }
    }
}