package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.entity.user.Comment;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.Post.CommentService;
import com.majorjava.monster.monster.service.Post.PostService;
import com.majorjava.monster.monster.service.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *帖子里面的评论
 * @author : ztf
 * @date : 2019-07-05 17:10
 **/
@Controller
public class CommentController {
    @Autowired
     private UserServices userServices; 
    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;

    @GetMapping("edit")
    private Map<String,Object> comment(Integer uid, String content, Integer pid, String systemName, Integer cid){
        User user = userServices.finByid(uid);
        Post post = postService.finByid(pid);
        Map<String,Object> map=new HashMap<>();
        Model model=null;
        switch (systemName){
            case "add" :
                Comment save = commentService.save(uid, pid, content);
                if (save!=null){
                    map.put("state","评论成功");
                }else {
                    map.put("state","评论失败");
                }
                break;
            case "delete" :
                int delete = commentService.delete(cid);
                 if (delete==0){
                     map.put("state","删除成功");
                 }else{
                     map.put("state","删除失败");
                 }
                     break;
            default:
        }
         return map;
    }
}
