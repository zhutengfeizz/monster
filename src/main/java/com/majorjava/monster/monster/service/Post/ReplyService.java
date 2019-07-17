package com.majorjava.monster.monster.service.Post;

import com.majorjava.monster.monster.entity.user.Reply;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-07-09 17:24
 **/
public interface ReplyService {
    void delete(Integer id);
    List<Reply> findByUserIdAndCommentId(Integer uid, Integer cid);
    List<Reply>findByCommentIdOrderByCreationTimeDesc(Integer cid);
    List<Reply> findByCommentId(Integer cid);
    Reply findById(Integer rid);
    Reply save(Reply reply);
}
