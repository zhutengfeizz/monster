package com.majorjava.monster.monster.service.impl.Post;

import com.majorjava.monster.monster.dao.PostDao;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.service.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-19 10:50
 **/
@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;


    @Override
    public List<Post> postAll() {
        List<Post> postList =(List<Post>) postDao.findByStateOrderByCreateTimeDesc(1);
        return postList;
    }

    @Override
    public Post save(Post post) {

        return postDao.save(post);
    }

    @Override
    public void delete(Integer id) {
        Post post = postDao.findById(id).get();
        post.setState(0);
        postDao.save(post);

    }

    @Override
    public Post finByid(Integer id) {
        return postDao.findById(id).get();
    }

    @Override
    public void finalDelete(Integer id) {
        postDao.deleteById(id);
    }

    @Override
    public List<Post> findBydelete() {
        return postDao.findByStateOrderByCreateTimeDesc(0);
    }

    @Override
    public List<Post> findByNameLikeAndStateOrderByCreateTimeDesc(String pname, int state) {
        return postDao.findByNameLikeAndStateOrderByCreateTimeDesc(pname,state);
    }

    @Override
    public Post findByName(String pname) {
        return postDao.findByName(pname);
    }

    @Override
    public Post findByNameLike(String pname) {
        return postDao.findByNameLike(pname);
    }


}
