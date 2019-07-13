package com.majorjava.monster.monster.service.impl.User;

import com.majorjava.monster.monster.dao.ResponsesInResponsesDao;
import com.majorjava.monster.monster.entity.user.ResponsesInResponses;
import com.majorjava.monster.monster.service.User.ResponsesInResponsesServices;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <h3>monster</h3>
 * <p>回复中的回复</p>
 *
 * @author : ztf
 * @date : 2019-07-14 07:34
 **/
public class ResponsesInResponsesServicesImpl  implements ResponsesInResponsesServices {
    @Autowired
    private ResponsesInResponsesDao responsesInResponsesDao;
    @Override
    public ResponsesInResponses save(Integer cid, Integer uid, String cont) {
        return responsesInResponsesDao.save(cid,uid,cont);
    }

    @Override
    public ResponsesInResponses findByCommentId(Integer cid) {
        return responsesInResponsesDao.findByCommentId(cid);
    }

    @Override
    public void delete(Integer cid) {
        ResponsesInResponses commentId = responsesInResponsesDao.findByCommentId(cid);
        responsesInResponsesDao.delete(commentId);
    }
}
