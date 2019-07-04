package com.majorjava.monster.monster.service.impl.Post;

import com.majorjava.monster.monster.dao.PartitionDao;
import com.majorjava.monster.monster.dao.PostDao;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.PostPartition;
import com.majorjava.monster.monster.service.Post.PartitionService;
import com.majorjava.monster.monster.service.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-19 10:50
 **/
@Service
@Transactional
public class PartitionServiceImpl implements PartitionService {
    @Autowired
    private PartitionDao partitionDao;


    @Override
    public List<PostPartition> postPartitionAll() {
        List<PostPartition> partitions = partitionDao.findByStateOrderByCreateTimeDesc(1);
        return partitions;
    }

    @Override
    public PostPartition save(PostPartition postPartition) {

        return partitionDao.save(postPartition);
    }

    @Override
    public void delete(Integer id) {
        PostPartition postPartition = partitionDao.findById(id).get();
        postPartition.setState(0);
        partitionDao.save(postPartition);

    }

    @Override
    public PostPartition finByid(Integer id) {
        PostPartition partition = partitionDao.findById(id).get();
        return partition;
    }

    @Override
    public List<PostPartition> findByTnameLikeAndStateOrderByCreateTimeDesc(String tname, int state) {
        return partitionDao.findByTnameLikeAndStateOrderByCreateTimeDesc(tname,state);
    }

    @Override
    public PostPartition findByTname(String tname) {
        return partitionDao.findByTname(tname);
    }

    @Override
    public PostPartition findByTnameLike(String name) {
        return partitionDao.findByTnameLike(name);
    }

}
