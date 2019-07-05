package com.majorjava.monster.monster.entity.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *评论的回复
 * @author : ztf
 * @date : 2019-06-13 11:45
 **/
@Entity
@Table(name = "t_reply")
@Data
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="comment_id")
    private Comment comment;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="user_id")
    private User user;
    @Column(name = "create_time", nullable = false)
    private Date creationTime;
    private String content;//内容
    @Column(insertable = false,columnDefinition = "int default 1")
    private int state;

}
