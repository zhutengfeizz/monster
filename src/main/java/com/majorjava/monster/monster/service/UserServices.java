package com.majorjava.monster.monster.service;

import com.majorjava.monster.monster.entity.user.User;

import java.util.List;
import java.util.Map;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-05 19:32
 **/
public interface UserServices {
    Map<String,Object> login (String username,String password);
    Map<String,Object> register(User user);


    User add(User user);
    void delete(Long id);
    User finByid(long id);
    User  update(User user);
    List<User> userFinall ();
    List<User> findAll();
    User findByUsername(String username);
    List<User> findBydelete();
}
