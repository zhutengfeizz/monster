package com.majorjava.monster.monster;

import com.majorjava.monster.monster.dao.CollectionsDao;
import com.majorjava.monster.monster.dao.FieldDao;
import com.majorjava.monster.monster.dao.PartitionDao;
import com.majorjava.monster.monster.dao.PostDao;
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

    @Test
    public void contextLoads() {
        /*Collections collections = new Collections();
        Collections collections1 = collectionsDao.findByUserIdAndPostId(28, 17);
        String error = null;
        if (collections1 == null) {
            User user = userServices.finByid(28);
            Post post = postService.finByid(17);
            if (user == null) {
            } else {
                collections.setUser(user);
                if (post == null) {
                } else {
                    collections.setPost(post);
                }
                collections.setCreateTime(new Date());
                Collections save = collectionsDao.save(collections);
                System.out.println(save.getUser().getUsername());
                System.out.println(save.getPost().getName());
                System.out.println(save.getCreateTime());
            }

        } else {
            System.out.println(collections1.getId());
            collectionsDao.delete(collections1);
        }
        System.out.println("=============================================================");
        System.out.println("根据用户的ID查找出所有的收藏");
        List<Collections> collectionsList = collectionsDao.findByUserIdOrderByCreateTimeDesc(28);
        for (Collections c : collectionsList) {
            System.out.println(c.getPost().getName());
        }*/
        Collections collections = collectionsServices.addCollections(28, 15);
        //控制台输出name=猫和老鼠
        System.out.println(collections.getPost().getName());
    }
}