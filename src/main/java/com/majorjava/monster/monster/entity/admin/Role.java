package com.majorjava.monster.monster.entity.admin;
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
    private Integer id;
    private String name;
    private String summary;//描述


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="t_role_permission",
            joinColumns = {@JoinColumn(name="role_id")},
            inverseJoinColumns = {@JoinColumn(name="permission_id")})
    private List<Permission> permissions=new ArrayList<Permission>();//角色的权限列表
    @Column(insertable = false,columnDefinition = "int default 1")
    private int state;


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", permissionList=" + permissions +
                '}';
    }
}
