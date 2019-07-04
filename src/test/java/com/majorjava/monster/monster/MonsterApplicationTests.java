package com.majorjava.monster.monster;

import com.hazelcast.core.Partition;
import com.majorjava.monster.monster.dao.FieldDao;
import com.majorjava.monster.monster.dao.PartitionDao;
import com.majorjava.monster.monster.dao.PostDao;
import com.majorjava.monster.monster.entity.user.PartitionField;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.PostPartition;
import javafx.geometry.Pos;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonsterApplicationTests {

    @Autowired
    private PartitionDao partitionDao;
    @Autowired
    private FieldDao fieldDao;
    @Autowired
    private PostDao postDao;

    @Test
    public void contextLoads() {
        List<Post> posts = postDao.findByFieldIdAndStateOrderByCreateTimeDesc(14, 1);
        for (Post p :posts){
            System.out.println(p.getName());
        }
    }

}
