package com.majorjava.monster.monster.dao.FollowersAndFans;

import com.majorjava.monster.monster.entity.FollowersAndFans.Relationship;
import com.majorjava.monster.monster.entity.FollowersAndFans.RelationshipPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *粉丝和被关注实现
 * @author : ztf
 * @date : 2019-06-20 10:32
 **/
public interface RelationshipRepository extends JpaRepository<Relationship, RelationshipPK> {

    /**
     * 2019/6/20
     * 描述一下方法的作用
     * 根据关注者id查找所有记录（查找关注的人的id）
     * @author ztf
     * @return java.util.List<java.lang.Integer>
     */
     @Query("select toUserId from Relationship where fromUserId=:fromUserId")
      List<Integer>findByFromUserId(@Param("fromUserId")Integer fromUserId);

     /**
      * 2019/6/20
      * 描述一下方法的作用
      *根据被关注者查找所有记录（查找粉丝的id）
      * @author ztf
      * @return java.util.List<java.lang.Integer>
      */
    @Query("select fromUserId from Relationship where toUserId =:toUserId")
    List<Integer> findByToUserId(@Param("toUserId") Integer toUserId);


    /**
     * 2019/6/20
     * 描述一下方法的作用
     *查询该用户的互相关注id
     * @author ztf
     * @return java.util.List<java.lang.Integer>
     */
    @Query(value = "SELECT DISTINCT t1.from_user_id FROM (SELECT * FROM relationship WHERE to_user_id = ?1)  AS t1 INNER JOIN relationship t2 ON t1.from_user_id = t2.to_user_id", nativeQuery = true)
    List<Integer> findFriendsByUserId(Integer userId);

    /**
     * 2019/6/20
     * 描述一下方法的作用
     *查询关注数
     * @author ztf
     * @return java.lang.Integer
     */
    Integer countByFromUserId(Integer fromUserId);

    /**
     * 2019/6/20
     * 描述一下方法的作用
     *查询粉丝数
     * @author ztf
     * @return java.lang.Integer
     */
    Integer countByToUserId(Integer toUserId);
}
