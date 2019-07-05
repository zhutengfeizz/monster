package com.majorjava.monster.monster.service.Post;

import com.majorjava.monster.monster.entity.user.Comment;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-07-05 17:20
 **/
public interface CommentService {
    List<Comment> findByUserIdAndStateOrderByCreationTime(int id, int state);
    Comment findByIdAndState(int id,int state);
}
