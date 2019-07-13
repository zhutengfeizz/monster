package com.majorjava.monster.monster.entity.user;

import com.majorjava.monster.monster.entity.admin.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-05 09:26
 **/
@Table(name = "t_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username", length = 32, unique = true, nullable = false)
    private String username;
    @Column(name = "password")
    private String password;
    private String headshot;//头像
    private String email;
    private String sex;
    private Date birthday;
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    private int age;
    @Column(name = "salt", length = 64, nullable = true)
    private String salt;
    private int state;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="t_user_role",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_id")})
    private List<Role> roles = new ArrayList<Role>();//用户拥有的角色列表
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Reply> replyList;
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Post> postList;
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Comment> commentList;
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Collections> collectionsList;//收藏
    @OneToMany(mappedBy = "thisUser",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<PrivateChat> privateChatList;//私信
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Idol> IdolList;//关注
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<ResponsesInResponses> responsesInResponsesList;//关注
    @Column(name = "follow_size",insertable = false,columnDefinition = "int default 0")
    private Integer followSize=0;//关注数
    @Column(name = "fan_size",insertable = false,columnDefinition = "int default 0")
    private Integer fanSize=0;//粉丝数
    @Transient
    private Integer isFriend = 0;//关系，0表示没有关系，2表示互相关注
    @Column(name = "svip",insertable = false,columnDefinition = "int default 0")
    private Integer svip;//0普通会员，1超级会员；
    private boolean signIn;//签到
    private String signature;//个性签名
    private String verification;//验证是否实名
    private String phone;//手机号码

    public List<PrivateChat> getPrivateChatList() {
        return privateChatList;
    }

    public void setPrivateChatList(List<PrivateChat> privateChatList) {
        this.privateChatList = privateChatList;
    }

    public List<Idol> getIdolList() {
        return IdolList;
    }

    public void setIdolList(List<Idol> idolList) {
        IdolList = idolList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Collections> getCollectionsList() {
        return collectionsList;
    }

    public void setCollectionsList(List<Collections> collectionsList) {
        this.collectionsList = collectionsList;
    }

    public Integer getFollowSize() {
        return followSize;
    }

    public void setFollowSize(Integer followSize) {
        this.followSize = followSize;
    }

    public Integer getFanSize() {
        return fanSize;
    }

    public void setFanSize(Integer fanSize) {
        this.fanSize = fanSize;
    }

    public Integer getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(Integer isFriend) {
        this.isFriend = isFriend;
    }

    public Integer getSvip() {
        return svip;
    }

    public void setSvip(Integer svip) {
        this.svip = svip;
    }

    public boolean isSignIn() {
        return signIn;
    }

    public void setSignIn(boolean signIn) {
        this.signIn = signIn;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", headshot='" + headshot + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", createTime=" + createTime +
                ", age=" + age +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", followSize=" + followSize +
                ", fanSize=" + fanSize +
                ", isFriend=" + isFriend +
                ", svip=" + svip +
                ", signIn=" + signIn +
                ", signature='" + signature + '\'' +
                ", verification='" + verification + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
