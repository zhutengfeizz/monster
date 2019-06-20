package com.majorjava.monster.monster.entity.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="user_id")
    private User user;
    @JoinColumn(name="sort")
    private String sort;//分类
    private String type;//投稿类型 （原创or转载）
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    private String content;//内容
    private String Introduction;//投稿简介
    private String img;//投稿封面
    @Column(insertable = false,columnDefinition = "int default 1")
    private int state;//状态
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Comment> commentList; //评论的集合（一个帖子有多个评论）
}
