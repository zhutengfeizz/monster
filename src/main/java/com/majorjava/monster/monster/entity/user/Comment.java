package com.majorjava.monster.monster.entity.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *评论
 * @author : ztf
 * @date : 2019-06-13 11:33
 **/
@Table(name = "t_comment")
@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cont;//评论的内容
    private Post postId;
    private User userId;
    @Column(name = "create_time", nullable = false)
    private Date creationTime;
}
