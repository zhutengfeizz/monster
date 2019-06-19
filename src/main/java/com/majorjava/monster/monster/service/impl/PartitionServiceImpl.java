package com.majorjava.monster.monster.service.impl;

import com.majorjava.monster.monster.dao.PostDao;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.mapper.PostMapper;
import com.majorjava.monster.monster.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
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
public class PartitionServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;
    @Autowired
    private PostMapper postMapper;
    @Override
    public Post addPost(Post post) {
        Post save = postDao.save(post);
        return save;
    }

    @Override
    public List<Post> postAll() {
        List<Post> postList = postMapper.findAll();
        return postList;
    }

    @Override
    public Post add(Post post) {

        return postDao.save(post);
    }

    @Override
    public void delete(Long id) {
        Post post = postDao.findById(id).get();
        post.setState(1);
        postDao.save(post);

    }

    @Override
    public Post finByid(long id) {
        return postDao.findById(id).get();
    }

    @Override
    public Post update(Post post) {
        Post post1=null;
        if (post.getId()==null){
            post1=new Post();
            post1.setName(post.getName());
            post1.setContent(post.getContent());
            post1.setType(post.getType());
            post1.setUser(post.getUser());
            post1.setCreateTime(new Timestamp(System.currentTimeMillis()));
            post1.setIntroduction(post.getIntroduction());
            post1.setImg(post.getImg());

        }else {
            long id=post.getId();
            post1=postDao.findById(id).get();
            post1.setContent(post.getContent());
            post1.setIntroduction(post.getIntroduction());

        }
        Post post2 = postDao.save(post1);

        return post2;

    }
}
