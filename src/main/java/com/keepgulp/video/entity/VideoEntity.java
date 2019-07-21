package com.keepgulp.video.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "v_video")
public class VideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "author")
    private String author;

    @Column(name = "video_id")
    private String videoId;

    @Column(name = "description")
    private String description;

    @Column(name = "like_count")
    private Long likeCount;

    @Column(name = "comment_count")
    private Long commentCount;

    @Column(name = "share_count")
    private Long shareCount;

    @Column(name = "music_author")
    private String musicAuthor;

    @Column(name = "music_title")
    private String musicTitle;

    @Column(name = "filename")
    private String filename;

    @Column(name = "download_url")
    private String downloadUrl;

    @Column(name = "create_time")
    private Date createTime;

}
