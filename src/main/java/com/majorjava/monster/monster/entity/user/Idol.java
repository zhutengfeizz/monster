package com.majorjava.monster.monster.entity.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *偶像类（用户的关注）
 * @author : ztf
 * @date : 2019-06-26 09:41
 **/
@Table(name = "t_idol")
@Entity
public class Idol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="user_id")
    private User user;//用户的ID
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="toUser_id")
    private User beUser;//被关注者的ID
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

    public User getBeUser() {
        return beUser;
    }

    public void setBeUser(User beUser) {
        this.beUser = beUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Idol{" +
                "id=" + id +
                ", createTime=" + createTime +
                '}';
    }
}
