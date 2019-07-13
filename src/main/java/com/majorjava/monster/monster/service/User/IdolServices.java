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
    void delete(Integer id);
    Idol add(Integer userId,Integer beUserId);
    //我关注的
    List<Idol> findByUserIdOrderByCreateTime(Integer userid);
    //关注我的
    List<Idol>findByBeUserIdOrderByCreateTime(Integer beUserid);
}
