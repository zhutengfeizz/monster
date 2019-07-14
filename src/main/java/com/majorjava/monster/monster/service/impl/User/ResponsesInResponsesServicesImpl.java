package com.majorjava.monster.monster.service.impl.User;

import com.majorjava.monster.monster.dao.ResponsesInResponsesDao;
import com.majorjava.monster.monster.entity.user.Comment;
import com.majorjava.monster.monster.entity.user.ResponsesInResponses;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.Post.CommentService;
import com.majorjava.monster.monster.service.User.ResponsesInResponsesServices;
import com.majorjava.monster.monster.service.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * <h3>monster</h3>
 * <p>回复中的回复</p>
 *
 * @author : ztf
 * @date : 2019-07-14 07:34
 **/
@Service
@Transactional
public class ResponsesInResponsesServicesImpl  implements ResponsesInResponsesServices {
    @Autowired
    private ResponsesInResponsesDao responsesInResponsesDao;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserServices userServices;
    @Override
    public ResponsesInResponses save(Integer cid, Integer uid, String cont) {
        ResponsesInResponses responsesInResponses=new ResponsesInResponses();
        Comment byIdAndState = commentService.findByIdAndState(cid,1);
        responsesInResponses.setComment(byIdAndState);
        User user = userServices.finByid(uid);
        responsesInResponses.setUser(user);
        responsesInResponses.setCont(cont);
        return responsesInResponsesDao.save(responsesInResponses);
    }



    @Override
    public ResponsesInResponses findByCommentId(Integer cid) {

        ResponsesInResponses byCommentId = responsesInResponsesDao.findByCommentId(cid);
        return byCommentId;
    }

    @Override
    public void delete(Integer rid) {
        ResponsesInResponses responsesInResponses = responsesInResponsesDao.findById(rid).get();
        responsesInResponsesDao.delete(responsesInResponses);
    }
}
