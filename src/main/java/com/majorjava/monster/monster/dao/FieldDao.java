package com.majorjava.monster.monster.dao;

import com.majorjava.monster.monster.entity.user.PartitionField;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-19 17:16
 **/
@Repository
public interface FieldDao extends CrudRepository<PartitionField, Integer> {
}
