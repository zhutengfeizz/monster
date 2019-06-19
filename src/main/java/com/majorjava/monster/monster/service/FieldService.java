package com.majorjava.monster.monster.service;

import com.majorjava.monster.monster.entity.user.PartitionField;
import com.majorjava.monster.monster.entity.user.Post;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-19 10:50
 **/
public interface FieldService {
    PartitionField addPartitionField(PartitionField partitionField);
    List<PartitionField> partitionFieldAll();
    PartitionField add(PartitionField partitionField);
    void delete(Long id);
    PartitionField finByid(long id);
    PartitionField update(PartitionField partitionField);

}
