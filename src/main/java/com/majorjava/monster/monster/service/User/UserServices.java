package com.majorjava.monster.monster.service.User;

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
    User save(User user);
    void delete(Integer id);
    User finByid(Integer id);
    User  update(User user);
    List<User> findAll();
    User findByUsername(String username);
    List<User> findBydelete();
    void finalDelete(Integer id);
    User  updateheadshot(Integer uid,String headshot);
    List<User>findByUsernameLikeAndStateOrderByCreateTimeDesc(String username, int state);
    User findByUsernameLike(String username);
    User findByPhoneAndUsername(String phone,String username);
}
