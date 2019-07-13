package com.majorjava.monster.monster;

import com.majorjava.monster.monster.dao.*;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.PrivateChat;
import com.majorjava.monster.monster.service.Post.CommentService;
import com.majorjava.monster.monster.service.Post.PostService;
import com.majorjava.monster.monster.service.User.CollectionsServices;
import com.majorjava.monster.monster.service.User.IdolServices;
import com.majorjava.monster.monster.service.User.PrivateChatServices;
import com.majorjava.monster.monster.service.User.UserServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    @Autowired
    private CollectionsServices collectionsServices;
    @Autowired
    private UserServices userServices;
    @Autowired
    private PostService postService;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private IdolServices idolServices;
    @Autowired
    private PrivateChatServices privateChatServices;

    @Test
    public void contextLoads() {
        String cont="测试一下留言";
        PrivateChat privateChat = privateChatServices.addPrivateChat(29, 28, cont);
        System.out.println("这个逼留言："+privateChat.getThisUserId().getUsername()+",给这个逼："+privateChat.getToUserId().getUsername()+",内容"+privateChat.getCont());
        List<PrivateChat> desc = privateChatServices.findByToUserIdOrderByCreateTimeDesc(28);
    }
}