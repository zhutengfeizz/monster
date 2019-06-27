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
@Data
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
                ", state=" + state+
                '}';
    }
}
