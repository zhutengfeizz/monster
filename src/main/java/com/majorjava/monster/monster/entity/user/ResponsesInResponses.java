package com.majorjava.monster.monster.entity.user;

import javax.persistence.*;

/**
 * <h3>monster</h3>
 * <p>回复中的回复</p>
 *
 * @author : ztf
 * @date : 2019-07-14 07:13
 **/
@Table(name = "t_responses_i_nresponses")
@Entity
public class ResponsesInResponses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="comment_id")
    private Comment comment;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="user_id")
    private User user;
    private String cont;
}
