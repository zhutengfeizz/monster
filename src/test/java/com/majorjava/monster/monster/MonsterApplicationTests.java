package com.majorjava.monster.monster;

import com.hazelcast.core.Partition;
import com.majorjava.monster.monster.dao.FieldDao;
import com.majorjava.monster.monster.dao.PartitionDao;
import com.majorjava.monster.monster.dao.PostDao;
import com.majorjava.monster.monster.entity.user.PartitionField;
import com.majorjava.monster.monster.entity.user.PostPartition;
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

    @Test
    public void contextLoads() {
        List<PartitionField> byPartitionId = fieldDao.findByPartitionId(2);
        for (PartitionField f:byPartitionId){
            System.out.println(f.getFname());
        }
    }

}
