package com.majorjava.monster.monster;

import com.majorjava.monster.monster.dao.*;
import com.majorjava.monster.monster.entity.user.Idol;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.PrivateChat;
import com.majorjava.monster.monster.entity.user.User;
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

       /* String cont="测试一下留言0";
        PrivateChat privateChat = privateChatServices.addPrivateChat(29, 28, cont);
        System.out.println("这个逼留言："+privateChat.getThisUser().getUsername()+",给这个逼："+privateChat.getToUser().getUsername()+",内容"+privateChat.getCont());
        //查看留言28号的对象or留言我的人
        List<PrivateChat> desc = privateChatServices.findByToUserIdOrderByCreateTimeDesc(28);
        List<PrivateChat> privateChatList=privateChatServices.findByThisUserIdOrderByCreateTimeDesc(29);
        if (privateChatList==null){
            System.out.println("没有查找东西回来");
        }else {
            System.out.println();
            System.out.println("是有值的");
        }

        for (PrivateChat a:privateChatList){
            System.out.println(a.getCont());
            System.out.println("============================================");
        }
        for (PrivateChat p:desc){
            System.out.println("这个逼的粉丝："+p.getThisUser().getUsername());
            System.out.println("============================================");
        }
        List<PrivateChat> timeDesc = privateChatServices.findByToUserIdOrderByCreateTimeDesc(32);
        for (PrivateChat p:timeDesc){
            System.out.println("内容："+p.getCont()+",是这个用户："+p.getThisUser().getUsername()+",留言给这个用户的："+p.getToUser().getUsername());
        }*/

/*
        Idol add = idolServices.add(35, 28);
        System.out.println("这个逼"+add.getUser().getUsername()+"关注了"+add.getBeUser().getUsername());

        List<Idol> order = idolServices.findByBeUserIdOrderByCreateTime(28);
        for (Idol idol:order){
            System.out.println(idol.getUser().getUsername()+"这个逼关注了:"+idol.getBeUser().getUsername());
        }
        System.out.println("===========================================");
        List<Idol> order1 = idolServices.findByUserIdOrderByCreateTime(29);
        for (Idol o:order1){
            System.out.println(o.getUser().getUsername()+"关注了"+o.getBeUser().getUsername());
        }*/
        Long aLong = idolServices.countByBeUserId(28);
        System.out.println(aLong);
        User open = userServices.findByPhoneAndUsername("13978985055", "open");
        System.out.println(open);
    }
}