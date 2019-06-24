package com.majorjava.monster.monster.service.Post;

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
    List<Post> postAll();
    Post save(Post post);
    void delete(Integer id);
    Post finByid(Integer id);
    void finalDelete(Integer id);
    List<Post> findBydelete();

}
