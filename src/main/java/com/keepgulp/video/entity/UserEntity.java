package com.keepgulp.video.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "v_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uid", length = 30)
    private String uid;

    @Column(name = "douyin_id")
    private String douyinId;

    @Column(name = "author")
    private String author;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "fans")
    private Long fans;

    @Column(name = "zan")
    private Long zan;

    @Column(name = "follows")
    private Long follows;

    @Column(name = "works")
    private Long works;

    @Column(name = "like_num")
    private Long likeNum;

    @Column(name = "info")
    private String info;

    @Column(name = "create_time")
    private Date createTime;

}
