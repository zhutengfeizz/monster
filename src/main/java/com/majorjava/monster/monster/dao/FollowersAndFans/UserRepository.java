package com.majorjava.monster.monster.dao.FollowersAndFans;

import com.majorjava.monster.monster.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *实现分页+关注粉丝关系
 * @author : ztf
 * @date : 2019-06-20 10:26
 **/
public interface UserRepository  extends JpaRepository<User, Integer> {
    /**
     * 2019/6/20
     * 描述一下方法的作用
     *根据ID集合查询用户，分页查询
     * @author ztf
     * @return org.springframework.data.domain.Page<com.majorjava.monster.monster.entity.user.User>
     */
    Page<User> findByIdIn(List<Integer> ids, Pageable pageable);

    /**
     * 2019/6/20
     * 描述一下方法的作用
     *根据Id集合查询用户，但不分页
     * @author ztf
     * @return java.util.List<com.majorjava.monster.monster.entity.user.User>
     */
    List<User>findByIdIn(List<Integer> ids);
}
