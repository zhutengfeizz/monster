package com.majorjava.monster.monster.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *帖子
 * @author : ztf
 * @date : 2019-06-13 11:15
 **/
@Entity
@Table(name = "t_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="user_id")
    private User user;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name="partition_id")
    private PostPartition partition;//分类
    private String type;//投稿类型 （原创or转载）
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    private String content;//内容
    private String Introduction;//投稿简介
    private String img;//投稿封面
    @Column(insertable = false,columnDefinition = "int default 1")
    private int state;//状态
/*    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Comment> commentList; //评论的集合（一个帖子有多个评论）*/
    @OneToMany(mappedBy  = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY )
    private List<Collection> collectionList;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name="field_id")
    private PartitionField field;//分区
    private Integer views;//访问量
    private Integer awesome;//点赞
    @JoinColumn(name="collection_id")
    private Collection collection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PostPartition getPartition() {
        return partition;
    }

    public void setPartition(PostPartition partition) {
        this.partition = partition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

   /* public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }*/

    public PartitionField getField() {
        return field;
    }

    public void setField(PartitionField field) {
        this.field = field;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getAwesome() {
        return awesome;
    }

    public void setAwesome(Integer awesome) {
        this.awesome = awesome;
    }
}
