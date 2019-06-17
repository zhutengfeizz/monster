package com.majorjava.monster.monster.entity.user;

import com.majorjava.monster.monster.entity.admin.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Long id;
    @Column(name = "username", length = 32, unique = true, nullable = false)
    private String username;
    @Column(name = "password")
    private String password;
    private String head;
    private String email;
    private String sex;
    private Date birthday;
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    private int age;
    @Column(name = "salt", length = 64, nullable = true)
    private String salt;
    private int state;
    @ManyToMany(fetch = FetchType.EAGER)//立即从数据库中进行加载数据；
    @JoinTable(name = "t_role", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {
            @JoinColumn(name = "rid")})
    private List<Role> roleList;
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Reply> replyList;
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Post> postList;
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Comment> commentList;
    @Transient
    public Set<String> getRolesName() {
        List<Role> roles = getRoleList();
        Set<String> set = new HashSet<String>();
        for (Role role : roles) {
            set.add(role.getRname());
        }
        return set;

    }

}
