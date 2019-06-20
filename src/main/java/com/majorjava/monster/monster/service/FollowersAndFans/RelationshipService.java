package com.majorjava.monster.monster.service.FollowersAndFans;

import com.majorjava.monster.monster.entity.FollowersAndFans.Relationship;
import com.majorjava.monster.monster.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-20 11:34
 **/
public interface RelationshipService {
    /**
     * 2019/6/20
     * 描述一下方法的作用
     *所有的关注者
     * @author ztf
     * @return org.springframework.data.domain.Page<com.majorjava.monster.monster.entity.user.User>
     */
    Page<User> listFollows(Integer userId, Pageable pageable);
    /**
     * 2019/6/20
     * 描述一下方法的作用
     *列出所有的粉丝
     * @author ztf
     * @return org.springframework.data.domain.Page<com.majorjava.monster.monster.entity.user.User>
     */
    Page<User> listFans(Integer userId,Pageable pageable);
    /**
     * 2019/6/20
     * 描述一下方法的作用
        列出相互关注的ID
     * @author ztf
     * @return java.util.List<java.lang.Integer>
     */
    List<Integer> listFriends(Integer userId);

    /**
     * 2019/6/20
     * 添加关系
     * @author ztf
     * @return void
     */
    void saveRelationship(Relationship relationship);
    /**
     * 2019/6/20
     * 去除关系
     * @author ztf
     * @return void
     */
    void removeRelationship(Relationship relationship);
    /**
     * 2019/6/20
     * 更新关注数量
     * @author ztf
     * @return void
     */
    void updateFollowSize(Integer userId);
    /**
     * 2019/6/20
     * 更新粉丝数
     * @author ztf
     * @return void
     */
    void updateFanSize(Integer userId);
}
