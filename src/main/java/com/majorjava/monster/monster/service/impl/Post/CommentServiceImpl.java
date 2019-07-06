package com.majorjava.monster.monster.service.impl.Post;
import com.majorjava.monster.monster.dao.CommentDao;
import com.majorjava.monster.monster.entity.user.Comment;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.Post.CommentService;
import com.majorjava.monster.monster.service.Post.PostService;
import com.majorjava.monster.monster.service.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
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
    @Autowired
    private  PostService postService;
    @Autowired
    private UserServices userServices;

    @Override
    public List<Comment> findByPostIdAndStateOrderByCreationTimeDesc(int pid, int state) {
        return commentDao.findByPostIdAndStateOrderByCreationTimeDesc(pid,1);
    }

    @Override
    public List<Comment> findByUserIdAndStateOrderByCreationTime(int id, int state) {
        return commentDao.findByUserIdAndStateOrderByCreationTime(id,state);
    }

    @Override
    public Comment findByIdAndState(int id, int state) {
        return commentDao.findByIdAndState(id,state);
    }

    @Override
    public Comment save(Integer uid,Integer pid,String cont) {
        Post post = postService.finByid(pid);
        User user = userServices.finByid(uid);
        Comment comment=new Comment();
        comment.setState(1);
        comment.setCreationTime(new Date());
        comment.setUser(user);
        comment.setPost(post);
        comment.setCont(cont);
        return commentDao.save(comment);
    }

    @Override
    public int delete(Integer cid) {
        Comment comment = commentDao.findById(cid).get();
        comment.setState(0);
        Comment save = commentDao.save(comment);
        int state = save.getState();
        return state;
    }


}
