package com.majorjava.monster.monster.service.User;

import com.majorjava.monster.monster.entity.user.Collections;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-07-08 11:19
 **/
public interface CollectionsServices {
    List<Collections> findByUserIdOrderByCreateTimeDesc(Integer id);
    Collections findByUserIdAndPostId(Integer uid,Integer pid);
    Collections addCollections(Integer uid, Integer pid);
     void delete(Integer id);
    Integer countByPostId(Integer pid);

}
