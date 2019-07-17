package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.entity.user.Collections;
import com.majorjava.monster.monster.entity.user.Idol;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.service.Post.PostService;
import com.majorjava.monster.monster.service.User.CollectionsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *收藏
 * @author : ztf
 * @date : 2019-07-08 17:14
 **/
@Controller
@RequestMapping("/collections")
public class CollectionsController {
    @Autowired
    private CollectionsServices collectionsServices;
    @Autowired
    private PostService postService;

    @ResponseBody
    @GetMapping("getSc")
    public Map<String,Object>getGz(Integer uid,Integer pid){
        System.out.println("是否收藏过：uid"+uid+",pid："+pid);
        Map<String,Object> map=new HashMap<>();
        Collections byUserIdAndPostId = collectionsServices.findByUserIdAndPostId(uid, pid);
        if (byUserIdAndPostId==null){
            map.put("code",'0');
        }else {
            map.put("code",'1');
        }
        return map;
    }

    @ResponseBody
    @GetMapping("add")
    public Map<String,Object> save(Integer uid, Integer pid){
        Collections byUserIdAndPostId = collectionsServices.findByUserIdAndPostId(uid, pid);
        System.out.println("添加收藏"+"uid:"+uid+",pid:"+pid);
        Map<String,Object> map=new HashMap<>();
            //先根据用户ID和帖子ID查找是否已经收藏过
            if (byUserIdAndPostId==null){
                //为null就是没收藏过，添加收藏
                Collections collections = collectionsServices.addCollections(uid, pid);
                if (collections==null){
                    map.put("code","0");
                    System.out.println("失败！");
                }else {
                    Post post = postService.finByid(pid);
                    post.setAwesome(post.getAwesome()+1);
                    map.put("code","1");
                    System.out.println("成功");
                }
            }else {
                //已经收藏过了则取消收藏
                Post post = postService.finByid(pid);
                post.setAwesome(post.getAwesome()-1);
                collectionsServices.delete(byUserIdAndPostId.getId());
                map.put("error","取消收藏成功！");
            }
        return map;
    }
}
