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
    public List<Comment> findByPostIdAndStateOrderByCreateTimeDesc(int pid, int state) {
        return commentDao.findByPostIdAndStateOrderByCreateTimeDesc(pid,1);
    }

    @Override
    public List<Comment> findByUserIdAndStateOrderByCreateTime(int id, int state) {
        return commentDao.findByUserIdAndStateOrderByCreateTimeDesc(id,state);
    }

    @Override
    public Comment findByIdAndState(int id, int state) {
        return commentDao.findByIdAndState(id,state);
    }

    @Override
    public Comment save(Integer uid,Integer pid,String cont) {
        Post post = postService.finByid(pid);
        User user = userServices.finByid(uid);
        Long aLong = commentDao.countByPostId(pid);
        System.out.println("当前帖子的评论数量："+aLong);
        aLong++;
        post.setCunt(aLong);
        Post save = postService.save(post);
        System.out.println("当前帖子的最新评论数量:"+save.getCunt());
        Comment comment=new Comment();
        comment.setState(1);
        comment.setCreateTime(new Date());
        comment.setUser(user);
        comment.setPost(post);
        comment.setCont(cont);
        comment.setNiceComment(1);
        System.out.println("这是在Impl输出的：post"+post.getName()+",user:"+user.getUsername());
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

    @Override
    public Long countByPostId(Integer pid) {
        return commentDao.countByPostId(pid);
    }


}
