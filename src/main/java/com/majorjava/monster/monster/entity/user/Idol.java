package com.majorjava.monster.monster.entity.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *偶像类（用户的关注表）
 * @author : ztf
 * @date : 2019-06-26 09:41
 **/
@Table(name = "t_idol")
@Entity
@Data
public class Idol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userID;//用户的ID
    private Integer beUserID;//被关注者的ID；
    private Date createTime;
    private int state;
}
