package com.majorjava.monster.monster.entity.admin;

import com.majorjava.monster.monster.entity.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-12 20:19
 **/
@Table(name = "t_role")
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;

    private String rname;

    @ManyToMany
    @JoinTable(name = "t_role",joinColumns ={ @JoinColumn(name = "rid") }, inverseJoinColumns = {
            @JoinColumn(name = "uid") })
    private List<User> userList;// 一个角色对应多个用户

    @OneToMany(mappedBy = "role", fetch=FetchType.EAGER)
    private List<Permission> permissionList;// 一个角色对应多个权限

    @Transient
    public List<String> getPermissionsName() {
        List<String> list = new ArrayList<String>();
        List<Permission> perlist = getPermissionList();
        for (Permission per : perlist) {
            list.add(per.getPname());
        }
        return list;
    }
}
