package com.majorjava.monster.monster.entity.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *帖子分区实体
 * @author : ztf
 * @date : 2019-06-19 16:33
 **/
@Entity
@Table(name="t_postPartition")
@Data
public class PostPartition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tname;
    @OneToMany(mappedBy = "partition",cascade= CascadeType.ALL,fetch= FetchType.LAZY)
    List<PartitionField> fieldList;
    private int state;
    @Column(name = "create_time", nullable = false)
    private Date createTime;

}
