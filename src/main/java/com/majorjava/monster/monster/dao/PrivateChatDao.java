package com.majorjava.monster.monster.dao;
import com.majorjava.monster.monster.entity.user.PrivateChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>留言</p>
 *
 * @author : ztf
 * @date : 2019-07-13 16:12
 **/
public interface PrivateChatDao extends CrudRepository<PrivateChat, Integer>, JpaRepository<PrivateChat, Integer>, JpaSpecificationExecutor<PrivateChat> {
         List<PrivateChat> findByThisUserIdOrderByCreateTimeDesc(Integer thisUserId);
         List<PrivateChat> findByToUserIdOrderByCreateTimeDesc(Integer toUserId);
}
