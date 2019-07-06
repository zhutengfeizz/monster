package com.majorjava.monster.monster;

import com.hazelcast.core.Partition;
import com.majorjava.monster.monster.dao.FieldDao;
import com.majorjava.monster.monster.dao.PartitionDao;
import com.majorjava.monster.monster.dao.PostDao;
import com.majorjava.monster.monster.entity.user.Comment;
import com.majorjava.monster.monster.entity.user.PartitionField;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.PostPartition;
import com.majorjava.monster.monster.service.Post.CommentService;
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
    @Autowired
    private CommentService commentService;

    @Test
    public void contextLoads() {
        Comment comment = commentService.save(28, 15, "猫和老鼠我从小看到大");
        System.out.println(comment);
        List<Comment> commentList = commentService.findByPostIdAndStateOrderByCreationTimeDesc(15, 1);
            for (Comment c:commentList){
                System.out.println(c.getCont());
            }
    }

}
