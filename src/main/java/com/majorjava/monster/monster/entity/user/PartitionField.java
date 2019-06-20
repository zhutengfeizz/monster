package com.majorjava.monster.monster.entity.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *帖子分区的领域
 * @author : ztf
 * @date : 2019-06-19 16:37
 **/
@Entity
@Table(name = "t_field")
@Data
public class PartitionField {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fname;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="partition_id")
    private PostPartition partition;
    @Column(insertable = false,columnDefinition = "int default 1")
    private int state;
    @Column(name = "create_time", nullable = false)
    private Date createTime;
}
