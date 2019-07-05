package com.majorjava.monster.monster.service.impl.Post;

import com.majorjava.monster.monster.dao.CommentDao;
import com.majorjava.monster.monster.entity.user.Comment;
import com.majorjava.monster.monster.service.Post.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-07-05 17:20
 **/
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Override
    public List<Comment> findByUserIdAndStateOrderByCreationTime(int id, int state) {
        return commentDao.findByUserIdAndStateOrderByCreationTime(id,state);
    }

    @Override
    public Comment findByIdAndState(int id, int state) {
        return commentDao.findByIdAndState(id,state);
    }
}
