package com.majorjava.monster.monster.service.impl.User;

import com.majorjava.monster.monster.dao.PrivateChatDao;
import com.majorjava.monster.monster.entity.user.PrivateChat;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.User.PrivateChatServices;
import com.majorjava.monster.monster.service.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * <h3>monster</h3>
 * <p>私信实现</p>
 *
 * @author : ztf
 * @date : 2019-07-13 16:20
 **/
@Service
@Transactional
public class PrivateChatImpl implements PrivateChatServices {
    @Autowired
    private PrivateChatDao privateChatDao;
    @Autowired
    UserServices userServices;

    @Override
    public PrivateChat addPrivateChat(Integer thisUserId, Integer toUserId, String cont) {
        User thisUser = userServices.finByid(thisUserId);
        User ToUser = userServices.finByid(toUserId);
        PrivateChat privateChat = new PrivateChat();
        privateChat.setThisUserId(thisUser);
        privateChat.setToUserId(ToUser);
        privateChat.setCont(cont);
        privateChat.setCreateTime(new Date());
        PrivateChat save = privateChatDao.save(privateChat);
        return save;
    }

    @Override
    public void delete(Integer id) {
        PrivateChat byId = privateChatDao.findById(id).get();
        privateChatDao.delete(byId);
    }

    @Override
    public List<PrivateChat> privateChatAll() {
        List<PrivateChat> all = privateChatDao.findAll();
        return all;
    }

    @Override
    public List<PrivateChat> findByThisUserIdOrderByCreateTimeDesc(Integer thisUserId) {
        return privateChatDao.findByThisUserIdOrderByCreateTimeDesc(thisUserId);
    }

    @Override
    public List<PrivateChat> findByToUserIdOrderByCreateTimeDesc(Integer toUserId) {
        return privateChatDao.findByToUserIdOrderByCreateTimeDesc(toUserId);
    }


}
