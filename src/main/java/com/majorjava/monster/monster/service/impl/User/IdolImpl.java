package com.majorjava.monster.monster.service.impl.User;

import com.majorjava.monster.monster.dao.IdolDao;
import com.majorjava.monster.monster.entity.user.Idol;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.User.IdolServices;
import com.majorjava.monster.monster.service.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <h3>monster</h3>
 * <p>关注</p>
 *
 * @author : ztf
 * @date : 2019-07-13 17:55
 **/
@Service
public class IdolImpl implements IdolServices {
    @Autowired
    private IdolDao idolDao;
    @Autowired
    private UserServices userServices;
    @Override
    public void delete(Integer id) {
        Idol idol = idolDao.findById(id).get();
        idolDao.delete(idol);
    }

    @Override
    public Idol add(Integer userId, Integer beUserId) {
        Idol idol=new Idol();
        User user = userServices.finByid(userId);
        User user1 = userServices.finByid(beUserId);
        idol.setUserId(user);
        idol.setBeUserId(user1);
        idol.setCreateTime(new Date());
        Idol save = idolDao.save(idol);
        return save;
    }

    @Override
    public List<Idol> findByUserIdOrderByCreateTime(Integer userid) {

        return idolDao.findByUserIdOrderByCreateTime(userid);
    }

    @Override
    public List<Idol> findByBeUserIdOrderByCreateTime(Integer beUserid) {
        return idolDao.findByBeUserIdOrderByCreateTime(beUserid);
    }
}
