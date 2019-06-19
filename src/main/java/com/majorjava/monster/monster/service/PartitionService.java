package com.majorjava.monster.monster.service;

import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.PostPartition;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-19 10:50
 **/
public interface PartitionService {
    PostPartition addPostPartition(PostPartition postPartition);
    List<PostPartition> postPartitionAll();
    PostPartition add(PostPartition postPartition);
    void delete(Long id);
    PostPartition finByid(long id);
    PostPartition update(PostPartition postPartition);

}
