package com.majorjava.monster.monster.dao;

import com.majorjava.monster.monster.entity.user.ResponsesInResponses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * <h3>monster</h3>
 * <p>回复中的回复</p>
 *
 * @author : ztf
 * @date : 2019-07-14 07:33
 **/
public interface ResponsesInResponsesDao extends CrudRepository<ResponsesInResponses, Integer>, JpaRepository<ResponsesInResponses, Integer>, JpaSpecificationExecutor<ResponsesInResponses> {
    ResponsesInResponses save(Integer cid,Integer uid,String cont);
    ResponsesInResponses findByCommentId(Integer cid);


}
