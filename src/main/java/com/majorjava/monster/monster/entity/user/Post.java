package com.majorjava.monster.monster.entity.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *帖子
 * @author : ztf
 * @date : 2019-06-13 11:15
 **/
@Entity
@Table(name = "t_post")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private User user;
    private Sort sort;//分类
    private String type;//投稿类型 （原创or转载）
    @Column(name = "create_time", nullable = false)
    private Date creationTime;
    private String content;//内容
    private String Introduction;//投稿简介
    private String img;//投稿封面
    private int state;
}
