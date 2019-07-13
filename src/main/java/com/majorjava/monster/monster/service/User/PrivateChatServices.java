package com.majorjava.monster.monster.service.User;

import com.majorjava.monster.monster.entity.user.PrivateChat;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>私信or留言</p>
 *
 * @author : ztf
 * @date : 2019-07-13 16:14
 **/
public interface PrivateChatServices {
    PrivateChat addPrivateChat(Integer thisUserId,Integer toUserId,String cont);
     void delete(Integer id);
     List<PrivateChat> privateChatAll();
    List<PrivateChat> findByThisUserIdOrderByCreateTimeDesc(Integer thisUserId);
    List<PrivateChat> findByToUserIdOrderByCreateTimeDesc(Integer toUserId);
}
