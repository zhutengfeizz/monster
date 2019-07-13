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
    private User userId;//用户的ID
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="toUser_id")
    private User beUserId;//被关注者的ID
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public User getBeUserId() {
        return beUserId;
    }

    public void setBeUserId(User beUserId) {
        this.beUserId = beUserId;
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
