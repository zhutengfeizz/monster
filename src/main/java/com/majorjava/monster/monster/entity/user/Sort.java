package com.majorjava.monster.monster.entity.user;

import lombok.Data;

import javax.persistence.*;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *分类
 * @author : ztf
 * @date : 2019-06-13 11:21
 **/
@Entity
@Table(name = "t_sort")
@Data
public class Sort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(insertable = false,columnDefinition = "int default 1")
    private int state;

}
