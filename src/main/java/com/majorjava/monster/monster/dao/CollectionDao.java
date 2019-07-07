package com.majorjava.monster.monster.dao;

import com.majorjava.monster.monster.entity.user.Collection;
import com.majorjava.monster.monster.entity.user.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-17 16:32
 **/
@Repository
public interface CollectionDao extends CrudRepository<Collection, Integer> {

}
