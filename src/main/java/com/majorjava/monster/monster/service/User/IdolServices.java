package com.majorjava.monster.monster.service.User;

import com.majorjava.monster.monster.entity.user.Idol;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>关注</p>
 *
 * @author : ztf
 * @date : 2019-07-13 17:46
 **/
public interface IdolServices {
    void delete(Idol idol);
    Idol add(Integer userId,Integer beUserId);
    //我关注的
    List<Idol> findByUserIdOrderByCreateTime(Integer userid);
    //关注我的
    List<Idol>findByBeUserIdOrderByCreateTime(Integer beUserid);
    //根据被关注的用户和当前用户查找关注对象
    Idol findByBeUserIdAndUserId(Integer beUserId,Integer userId);
    Idol findById(Integer id);
    Long countByBeUserId(Integer beUserId);
}
