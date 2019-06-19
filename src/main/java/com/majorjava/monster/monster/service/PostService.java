package com.majorjava.monster.monster.service;

import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.User;
import javafx.geometry.Pos;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-19 10:50
 **/
public interface PostService  {
    Post addPost(Post post);
    List<Post> postAll();
    Post add(Post post);
    void delete(Long id);
    Post finByid(long id);
    Post update(Post post);

}
