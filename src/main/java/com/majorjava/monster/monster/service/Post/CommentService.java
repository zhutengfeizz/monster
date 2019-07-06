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
    List<Comment> findByPostIdAndStateOrderByCreationTimeDesc(int pid,int state);
    List<Comment> findByUserIdAndStateOrderByCreationTime(int uid, int state);
    Comment findByIdAndState(int cid,int state);
    Comment save(Integer uid,Integer pid,String cont);
    int delete(Integer cid);
}