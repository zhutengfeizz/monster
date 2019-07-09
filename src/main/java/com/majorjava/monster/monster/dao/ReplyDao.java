package com.majorjava.monster.monster.dao;

import com.majorjava.monster.monster.entity.user.Comment;
import com.majorjava.monster.monster.entity.user.Reply;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-07-05 17:11
 **/
public interface ReplyDao extends CrudRepository<Reply, Integer> {
      List<Reply>findByUserIdAndCommentId(Integer uid,Integer cid);
      List<Reply>findByCommentIdOrderByCreationTimeDesc(Integer cid);
}
