package com.majorjava.monster.monster.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class PartitionField {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fname;

    @JsonIgnore
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="partition_id")
    private PostPartition partition;
    @Column(insertable = false,columnDefinition = "int default 1")
    private int state;
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public PostPartition getPartition() {
        return partition;
    }

    public void setPartition(PostPartition partition) {
        this.partition = partition;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
