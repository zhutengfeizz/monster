package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.entity.user.Collections;
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
 *
 * @author : ztf
 * @date : 2019-07-08 17:14
 **/
@Controller
@RequestMapping("/collections")
public class CollectionsController {
    @Autowired
    private CollectionsServices collectionsServices;

    @ResponseBody
    @GetMapping("add")
    public Map save(Integer uid, Integer pid){
        Collections byUserIdAndPostId = collectionsServices.findByUserIdAndPostId(uid, pid);
        Map<String,Object> map=new HashMap<>();
        if (uid==null) {
            map.put("error", "请您先登录账号");
            if (pid == null) {
                map.put("error", "帖子不存在！已丢失或者删除了。");
            }
        }else {
            //先根据用户ID和帖子ID查找是否已经收藏过
            if (byUserIdAndPostId==null){
                //为null就是没收藏过，添加收藏
                Collections collections = collectionsServices.addCollections(uid, pid);
                if (collections==null){
                    map.put("error","收藏失败！");
                }else {
                    map.put("error","收藏成功");
                }
            }else {
                //已经收藏过了则取消收藏
                collectionsServices.delete(byUserIdAndPostId.getId());
                map.put("error","取消收藏成功！");
            }

        }
        return map;
    }
}
