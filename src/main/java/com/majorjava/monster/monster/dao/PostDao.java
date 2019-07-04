package com.majorjava.monster.monster.dao;

import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.User;
import javafx.geometry.Pos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-17 16:32
 **/
@Repository
public interface PostDao extends CrudRepository<Post, Integer> {
    List<Post> findByStateOrderByCreateTimeDesc(int state);
    List<Post>findByNameLikeAndStateOrderByCreateTimeDesc(String pname,int state);
    List<Post>findByFieldIdAndStateOrderByCreateTimeDesc(Integer id,int state);
    List<Post>findByPartitionIdAndStateOrderByCreateTimeDesc(Integer id,int state);
    List<Post>findAllByStateOrderByViewsDesc(int state);
    Post findByName(String pname);
    Post findByNameLike(String pname);
}
