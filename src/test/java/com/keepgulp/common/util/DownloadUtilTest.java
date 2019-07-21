package com.keepgulp.common.util;

import com.keepgulp.video.model.VideoModel;
import com.keepgulp.video.service.VideoParseService;
import com.keepgulp.video.service.impl.VideoFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DownloadUtilTest {

    @Test
    public void downloadVideo() throws IOException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        String rootDir = Test.class.getClassLoader().getResource("").getPath();
        String videosDir = rootDir + "/videos";
        List<String> urlList = Arrays.asList("http://v.douyin.com/BWQAk1",
                "http://m.chenzhongtech.com/s/mhn5haAq/");

        for(String url : urlList) {
            VideoParseService videoParseService = VideoFactory.getVideo(url);
            VideoModel videoModel = videoParseService.parseUrl(url);
            String fileName = videosDir + "/" + videoModel.getName().trim() + ".mp4";
            DownloadUtil.downloadVideo(videoModel.getPlayAddr(), fileName);
        }
    }
}