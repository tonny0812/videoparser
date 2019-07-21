package com.keepgulp.video.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "v_comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "video_id")
    private String videoId;

    @Column(name = "user")
    private String user;

    @Column(name = "content")
    private String content;

    @Column(name = "like_count")
    private Long likeCount;

    @Column(name = "comment_time")
    private Date CommentTime;

    @Column(name = "comment_count")
    private Long commentCount;

    @Column(name = "beReplied_user")
    private String beRepliedUser;

    @Column(name = "beReplied_content")
    private String beRepliedContent;

    @Column(name = "beReplied_like_count")
    private Long beRepliedLikeCount;

    @Column(name = "beReplied_comment_time")
    private Date beRepliedCommentTime;

    @Column(name = "create_time")
    private Date createTime;
}
