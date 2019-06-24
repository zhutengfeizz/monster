package com.majorjava.monster.monster.entity.admin;

import lombok.Data;

import javax.persistence.*;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-12 20:18
 **/
@Table(name = "t_permission")
@Entity
@Data
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;


    private String pname; //权限名字

    private String url;//权限Url

    @Column(insertable = false,columnDefinition = "int default 1")
    private int state;

}
