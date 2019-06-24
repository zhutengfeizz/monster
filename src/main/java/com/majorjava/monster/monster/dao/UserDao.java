package com.majorjava.monster.monster.dao;

import com.majorjava.monster.monster.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-05 19:37
 **/
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    User findByUsername(String username);

    List<User> findByStateOrderByCreateTimeDesc(int state);
}
