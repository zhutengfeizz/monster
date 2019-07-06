package com.majorjava.monster.monster.entity.user;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * <h3>monster</h3>
 * <p>monster</p>
 *用户的收藏实体类
 * @author : ztf
 * @date : 2019-07-07 05:55
 **/
@Table(name = "t_collection")
@Component
@Data
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="post_id")
    private Post post;
}
