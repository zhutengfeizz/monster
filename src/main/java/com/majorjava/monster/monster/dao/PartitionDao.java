package com.majorjava.monster.monster.dao;


import com.majorjava.monster.monster.entity.user.PartitionField;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.PostPartition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-19 17:16
 **/
@Repository
public interface PartitionDao extends CrudRepository<PostPartition, Integer> {
    List<PostPartition> findByStateOrderByCreateTimeDesc(int state);
    List<PostPartition>findByTnameLikeAndStateOrderByCreateTimeDesc(String tname, int state);
    PostPartition findByTname(String tname);
    PostPartition findByTnameLike(String tname);
}
