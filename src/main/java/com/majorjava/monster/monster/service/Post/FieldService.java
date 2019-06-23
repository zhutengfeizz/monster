package com.majorjava.monster.monster.service.Post;

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
    List<PartitionField> partitionFieldAll();
    PartitionField save(PartitionField partitionField);
    void delete(Integer id);
    PartitionField finByid(Integer id);

}
