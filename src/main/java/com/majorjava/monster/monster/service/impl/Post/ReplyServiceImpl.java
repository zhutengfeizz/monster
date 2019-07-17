package com.majorjava.monster.monster.service.impl.Post;
import com.majorjava.monster.monster.dao.ReplyDao;
import com.majorjava.monster.monster.entity.user.Reply;
import com.majorjava.monster.monster.service.Post.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public List<Reply> findByUserIdAndCommentId(Integer uid, Integer cid) {
        return replyDao.findByUserIdAndCommentId(uid,cid);
    }

    @Override
    public List<Reply> findByCommentIdOrderByCreationTimeDesc(Integer cid) {
        return replyDao.findByCommentIdOrderByCreationTimeDesc(cid);
    }

    @Override
    public List<Reply> findByCommentId(Integer rid) {
        return replyDao.findByCommentId(rid);
    }

    @Override
    public Reply findById(Integer rid) {
        return replyDao.findById(rid).get();
    }

    @Override
    public Reply save(Reply reply) {
        return replyDao.save(reply);
    }
}
