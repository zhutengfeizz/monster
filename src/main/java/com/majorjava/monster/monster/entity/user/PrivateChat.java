package com.majorjava.monster.monster.entity.user;

import javax.persistence.*;
import java.util.Date;

/**
 * <h3>monster</h3>
 * <p>私聊</p>
 *
 * @author : ztf
 * @date : 2019-07-13 16:02
 **/
@Entity
@Table(name = "t_privateChat")
public class PrivateChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="thisUser_id")
    private User  thisUser;//当前用户的ID
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="toUser_id")
    private User toUser;//留言给这个ID
    private String cont;//内容、
    private Date createTime;//留言的时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getThisUser() {
        return thisUser;
    }

    public void setThisUser(User thisUser) {
        this.thisUser = thisUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PrivateChat{" +
                "id=" + id +
                ", cont='" + cont + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
