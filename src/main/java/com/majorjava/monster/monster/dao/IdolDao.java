package com.majorjava.monster.monster.dao;

import com.majorjava.monster.monster.entity.user.Idol;
import com.majorjava.monster.monster.entity.user.PrivateChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>关注</p>
 *
 * @author : ztf
 * @date : 2019-07-13 17:14
 **/
public interface IdolDao extends CrudRepository<Idol, Integer>, JpaRepository<Idol, Integer>, JpaSpecificationExecutor<Idol> {
    //我关注的
    List<Idol> findByUserIdOrderByCreateTime(Integer userId);
    //关注我的
    List<Idol>findByBeUserIdOrderByCreateTime(Integer beUserId);
    //根据被关注的用户和当前用户查找关注对象
    Idol findByBeUserIdAndUserId(Integer beUserId,Integer userId);
    Long countByBeUserId(Integer beUserId);
}
