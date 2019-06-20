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
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="post_id")
    private Post post;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="user_id")
    private User user;
    @Column(name = "create_time", nullable = false)
    private Date creationTime;
    @Column(insertable = false,columnDefinition = "int default 1")
    private int state;
}
