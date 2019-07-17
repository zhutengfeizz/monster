package com.majorjava.monster.monster.service.impl.User;

import com.majorjava.monster.monster.dao.CollectionsDao;
import com.majorjava.monster.monster.entity.user.Collections;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.Post.PostService;
import com.majorjava.monster.monster.service.User.CollectionsServices;
import com.majorjava.monster.monster.service.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-07-08 11:21
 **/
@Service
@Transactional
public class CollerctionsServicesImpl implements CollectionsServices {
    @Autowired
    private CollectionsDao collectionsDao;
    @Autowired
    private UserServices userServices;
    @Autowired
    private PostService postService;

    @Override
    public List<Collections> findByUserIdOrderByCreateTimeDesc(Integer id) {
        return collectionsDao.findByUserIdOrderByCreateTimeDesc(id);
    }

    @Override
    public Collections findByUserIdAndPostId(Integer uid, Integer pid) {
        return collectionsDao.findByUserIdAndPostId(uid,pid);
    }


    @Override
    public Collections addCollections(Integer uid,Integer pid) {
        Collections collections1 = collectionsDao.findByUserIdAndPostId(uid, pid);
      Collections collection=null;
        Map<String,Object>map=new HashMap<>();
        if (collections1 == null) {
            Collections collections = new Collections();
            User user = userServices.finByid(uid);
            Post post = postService.finByid(pid);
                collections.setUser(user);
                collections.setPost(post);
                collections.setCreateTime(new Date());
                 collection = collectionsDao.save(collections);
                /* map.put("collection",collection);*/
            } else {
            System.out.println(collections1.getId());
            collectionsDao.delete(collections1);
           /* map.put("error","取消收藏成功！");*/
        }
        return collection;
    }

    @Override
    public void delete(Integer id) {
        collectionsDao.deleteById(id);
    }

    @Override
    public Integer countByPostId(Integer pid) {
        return collectionsDao.countByPostId(pid);
    }
}
