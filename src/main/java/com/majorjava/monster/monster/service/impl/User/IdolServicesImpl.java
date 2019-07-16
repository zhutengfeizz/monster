package com.majorjava.monster.monster.service.impl.User;

import com.majorjava.monster.monster.dao.IdolDao;
import com.majorjava.monster.monster.entity.user.Idol;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.User.IdolServices;
import com.majorjava.monster.monster.service.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
@Transactional
public class IdolServicesImpl implements IdolServices {
    @Autowired
    private IdolDao idolDao;
    @Autowired
    private UserServices userServices;
    @Override
    public void delete(Idol idol) {
        idolDao.delete(idol);
    }

    @Override
    public Idol add(Integer uid, Integer beUid) {
        Idol idol=new Idol();
        User user = userServices.finByid(uid);
        System.out.println("创建关注对象传过来的user"+user.getUsername());
        User beUser = userServices.finByid(beUid);
        System.out.println("创建关注对象传过来被关注的user"+beUser.getUsername());
        beUser.setFanSize(user.getFanSize()+1);
        User saveBeUser = userServices.save(beUser);
        user.setFollowSize(user.getFollowSize()+1);
       User saveUser= userServices.save(user);


        idol.setUser(saveUser);
        idol.setBeUser(saveBeUser);
        idol.setCreateTime(new Date());
        Idol save = idolDao.save(idol);
        if (save!=null){
            System.out.println(save.getUser().getUsername()+",这个逼刚才关注了"+save.getBeUser().getUsername());
            System.out.println("关注成功!");
        }else {
            System.out.println(save.getUser().getUsername()+",这个逼刚才关注了"+save.getBeUser().getUsername());
            System.out.println("关注失败!");
        }
        return save;
    }

    @Override
    public List<Idol> findByUserIdOrderByCreateTime(Integer userid) {
        List<Idol> byUserIdOrderByCreateTime = idolDao.findByUserIdOrderByCreateTime(userid);
        System.out.println(byUserIdOrderByCreateTime.size());
        return byUserIdOrderByCreateTime;
    }


    @Override
    public List<Idol> findByBeUserIdOrderByCreateTime(Integer beUserid) {
        List<Idol> byBeUserIdOrderByCreateTime = idolDao.findByBeUserIdOrderByCreateTime(beUserid);
        System.out.println(byBeUserIdOrderByCreateTime.size());
        return byBeUserIdOrderByCreateTime;
    }

    @Override
    public Idol findByBeUserIdAndUserId(Integer beUserId, Integer userId) {
        Idol byBeUserIdAndUserId = idolDao.findByBeUserIdAndUserId(beUserId, userId);
        return byBeUserIdAndUserId;
    }

    @Override
    public Idol findById(Integer id) {
        return idolDao.findById(id).get();
    }

    @Override
    public Long countByBeUserId(Integer beUserId) {
        return idolDao.countByBeUserId(beUserId);
    }
}
