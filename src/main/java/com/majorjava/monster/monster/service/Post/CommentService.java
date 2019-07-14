package com.majorjava.monster.monster.service.Post;

import com.majorjava.monster.monster.entity.user.Comment;
import com.majorjava.monster.monster.entity.user.Post;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-07-05 17:20
 **/
public interface CommentService {
    List<Comment> findByPostIdAndStateOrderByCreateTimeDesc(Integer pid,Integer state);
    List<Comment> findByUserIdAndStateOrderByCreateTime(Integer uid, Integer state);
    Comment findByIdAndState(Integer cid,Integer state);
    Comment save(Integer uid,Integer pid,String cont,String ip);
    int delete(Integer cid);
    Long countByPostId(Integer pid);
}
