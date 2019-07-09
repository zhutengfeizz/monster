package com.majorjava.monster.monster;

import com.majorjava.monster.monster.dao.*;
import com.majorjava.monster.monster.entity.user.*;
import com.majorjava.monster.monster.service.Post.CommentService;
import com.majorjava.monster.monster.service.Post.PostService;
import com.majorjava.monster.monster.service.User.CollectionsServices;
import com.majorjava.monster.monster.service.User.UserServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



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
    @Autowired
    private CollectionsServices collectionsServices;
    @Autowired
    private UserServices userServices;
    @Autowired
    private PostService postService;
    @Autowired
    private CommentDao commentDao;

    @Test
    public void contextLoads() {
        Long id = commentDao.countByPostId(15);
        System.out.println(id);
    }
}