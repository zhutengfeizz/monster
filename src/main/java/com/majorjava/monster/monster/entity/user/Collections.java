package com.majorjava.monster.monster.entity.user;



import javax.persistence.*;
import java.util.Date;

/**
 * <h3>monster</h3>
 * <p>monster</p>
 *用户的收藏实体类
 * @author : ztf
 * @date : 2019-07-07 05:55
 **/
@Table(name = "t_collection")
@Entity
public class Collections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="user_id")
    private User user;


    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="post_id")
    private Post post;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Collections{" +
                "id=" + id +
                ", user=" + user +
                ", post=" + post +
                ", createTime=" + createTime +
                '}';
    }
}
