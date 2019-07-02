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
public class PostPartition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tname;
    @OneToMany(mappedBy = "partition",cascade= CascadeType.ALL,fetch= FetchType.LAZY)
    List<PartitionField> fieldList;
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

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<PartitionField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<PartitionField> fieldList) {
        this.fieldList = fieldList;
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
