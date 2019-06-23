package com.majorjava.monster.monster.service.Post;

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
    List<PostPartition> postPartitionAll();
    PostPartition save(PostPartition postPartition);
    void delete(Integer id);
    PostPartition finByid(Integer id);
}
