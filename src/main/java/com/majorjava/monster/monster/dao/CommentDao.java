package com.majorjava.monster.monster.dao;

import com.majorjava.monster.monster.entity.user.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-07-05 17:11
 **/
public interface CommentDao extends CrudRepository<Comment, Integer> {
    List<Comment> findByUserIdAndStateOrderByCreateTimeDesc(Integer id,Integer state);
    Comment findByIdAndState(Integer id,Integer state);
    List<Comment> findByPostIdAndStateOrderByCreateTimeDesc(Integer pid,Integer state);
    Long countByPostId(Integer pid);

}
