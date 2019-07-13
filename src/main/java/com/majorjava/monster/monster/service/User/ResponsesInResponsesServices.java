package com.majorjava.monster.monster.service.User;

import com.majorjava.monster.monster.entity.user.ResponsesInResponses;
import org.springframework.stereotype.Service;

/**
 * <h3>monster</h3>
 * <p>回复中的回复</p>
 *
 * @author : ztf
 * @date : 2019-07-14 07:33
 **/
@Service
public interface ResponsesInResponsesServices {
    ResponsesInResponses save(Integer cid, Integer uid, String cont);
    ResponsesInResponses findByCommentId(Integer cid);
    void delete(Integer cid);
}
