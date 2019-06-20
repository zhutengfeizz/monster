package com.majorjava.monster.monster.service.impl.Post;

import com.majorjava.monster.monster.dao.PartitionDao;
import com.majorjava.monster.monster.dao.PostDao;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.PostPartition;
import com.majorjava.monster.monster.mapper.PartitionMapper;
import com.majorjava.monster.monster.mapper.PostMapper;
import com.majorjava.monster.monster.service.Post.PartitionService;
import com.majorjava.monster.monster.service.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
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
    @Autowired
    private PartitionMapper partitionMapper;

    @Override
    public PostPartition addPostPartition(PostPartition postPartition) {
        PostPartition p=new PostPartition();
         p.setTname(postPartition.getTname());
         p.setCreateTime(new Timestamp(System.currentTimeMillis()));
        PostPartition save = partitionDao.save(p);
        return save;
    }

    @Override
    public List<PostPartition> postPartitionAll() {
        List<PostPartition> partitions = partitionMapper.findAll();
        return partitions;
    }

    @Override
    public PostPartition add(PostPartition postPartition) {

        return partitionDao.save(postPartition);
    }

    @Override
    public void delete(Long id) {
        PostPartition postPartition = partitionDao.findById(id).get();
        postPartition.setState(0);
        partitionDao.save(postPartition);

    }

    @Override
    public PostPartition finByid(long id) {
        PostPartition partition = partitionDao.findById(id).get();
        return partition;
    }

    @Override
    public PostPartition update(PostPartition postPartition) {
        Long pid=postPartition.getId().longValue();
        PostPartition p=null;
         if(pid!=null){
             PostPartition partition = partitionDao.findById(pid).get();
             partition.setTname(postPartition.getTname());
             p = partitionDao.save(partition);
         }else {
           PostPartition  p1=postPartition;
             p1.setCreateTime(new Timestamp(System.currentTimeMillis()));
              p = partitionDao.save(p1);
         }

        return p;
    }
}
