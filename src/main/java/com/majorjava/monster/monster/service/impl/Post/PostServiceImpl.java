package com.majorjava.monster.monster.service.impl.Post;

import com.majorjava.monster.monster.dao.PostDao;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.mapper.PostMapper;
import com.majorjava.monster.monster.service.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
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
    @Autowired
    private PostMapper postMapper;


    @Override
    public List<Post> postAll() {
        List<Post> postList =(List<Post>) postMapper.findAll();
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


}
