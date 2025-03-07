package com.keepgulp.video.controller;

import java.util.Objects;

import org.springframework.web.bind.annotation.*;

import com.keepgulp.video.model.VideoModel;
import com.keepgulp.video.service.VideoParseService;
import com.keepgulp.video.service.impl.VideoFactory;

/**  
* @comment
* @author tanran 
* @date 2019年6月14日  
* @version 1.0  
*/
@RestController
@RequestMapping("video")
@CrossOrigin
public class VideoController {
	@GetMapping("parse")
	public VideoModel parse(@RequestParam(value = "url") String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		 VideoParseService videoParseService = VideoFactory.getVideo(url);
		 if(Objects.isNull(videoParseService)) {
			 return new VideoModel();
		 }
		 return videoParseService.parseUrl(url);
	}
}
