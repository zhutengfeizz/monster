package com.majorjava.monster.monster.service.impl.Post;
import com.majorjava.monster.monster.dao.ReplyDao;
import com.majorjava.monster.monster.service.Post.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-07-05 17:20
 **/
@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

    @Autowired
  private ReplyDao replyDao;

    @Override
    public void delete(Integer rid) {
        replyDao.deleteById(rid);
    }
}