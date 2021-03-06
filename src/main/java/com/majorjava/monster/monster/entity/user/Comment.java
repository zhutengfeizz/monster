package com.majorjava.monster.monster.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *评论
 * @author : ztf
 * @date : 2019-06-13 11:33
 **/
@Table(name = "t_comment")
@Entity
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
    private Date createTime;
    @Column(insertable = false,columnDefinition = "int default 1")
    private Integer state;
    @OneToMany(mappedBy = "comment",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<ResponsesInResponses> responsesInResponsesList;
    @JsonIgnore
    @Column(name = "niceComment")
    private int niceComment;
    private String ip;
    private int number;//第几楼

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getNiceComment() {
        return niceComment;
    }

    public void setNiceComment(int niceComment) {
        this.niceComment = niceComment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", cont='" + cont + '\'' +
                ", post=" + post +
                ", user=" + user +
                ", createTime=" + createTime +
                ", state=" + state +
                ", niceComment=" + niceComment +
                '}';
    }
}
