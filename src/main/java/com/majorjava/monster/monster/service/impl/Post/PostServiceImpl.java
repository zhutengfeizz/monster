package com.majorjava.monster.monster.service.impl.Post;

import com.majorjava.monster.monster.dao.PostDao;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.service.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
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

    /*无查询条件的分页*/
    @Override
    public List<Post> findPostNoCriteria(Integer page, Integer size) {
        PageRequest pageRequest=PageRequest.of(page,size,Sort.Direction.ASC,"id");
        Page<Post> postPage=postDao.findAll(pageRequest);
        List<Post> posts=postPage.getContent();
        for (Post t:posts){
            System.out.println(t.getName());
        }
        return posts;
    }
    /*有查询条件的分页*/
    @Override
    public Page<Post> findPostCriteria(Integer page, Integer size,final Post post) {
      Pageable pageable=PageRequest.of(page,size,Sort.Direction.ASC,"id");
      Page<Post> postPage=postDao.findAll(new Specification<Post>() {
          @Override
          public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
              List<Predicate> list = new ArrayList<Predicate>();
              /*根据帖子名字*/
              if (null!=post.getName()&&!"".equals(post.getName())){
                  list.add(criteriaBuilder.equal(root.get("name").as(String.class),post.getName()));
              }
              /*帖子类型*/
              if (null!=post.getType()&&!"".equals(post.getType())){
                  list.add(criteriaBuilder.equal(root.get("type").as(String.class),post.getType()));
              }
              /*帖子领域*/
              if (null!=post.getField().getFname()&&!"".equals(post.getField().getFname())){
                  list.add(criteriaBuilder.equal(root.get("type").as(String.class),post.getField().getFname()));
              }
              /*帖子分区*/
              if (null!=post.getPartition().getTname()&&!"".equals(post.getPartition().getTname())){
                  list.add(criteriaBuilder.equal(root.get("partition").as(String.class),post.getPartition().getTname()));
              }
              /*根据用户名*/
              if (null!=post.getUser().getUsername()&&!"".equals(post.getUser().getUsername())){
                  list.add(criteriaBuilder.equal(root.get("username").as(String.class),post.getUser().getUsername()));
              }
              /*根据帖子ID*/
              if (null!=post.getId()&&!"".equals(post.getId())){
                  list.add(criteriaBuilder.equal(root.get("pid").as(String.class),post.getId()));
              }
              /*根据帖子简介*/
              if (null!=post.getIntroduction()&&!"".equals(post.getIntroduction())){
                  list.add(criteriaBuilder.equal(root.get("type").as(String.class),post.getIntroduction()));
              }
              /*根据帖子内容*/
              if (null!=post.getContent()&&!"".equals(post.getContent())){
                  list.add(criteriaBuilder.equal(root.get("type").as(String.class),post.getContent()));
              }
              Predicate[] p =new Predicate[list.size()];
              return criteriaBuilder.and(list.toArray(p));
          }
      },pageable);
        return postPage;
    }


}
