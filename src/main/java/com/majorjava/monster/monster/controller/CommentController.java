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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/comment")
public class CommentController {
    @Autowired
     private UserServices userServices; 
    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;

    @ResponseBody
    @GetMapping("add")
    private Map<String,Object> comment(Integer uid, String content, Integer pid,String ip){
        System.out.println("ajax传过来的uid:"+uid+",帖子id："+pid+"评论的内容"+content+",传过来的ip是："+ip);
        User user = userServices.finByid(uid);
        Post post = postService.finByid(pid);
        Map<String,Object> map=new HashMap<>();
        Model model=null;
                Comment save = commentService.save(uid, pid, content,ip);
                if (save!=null){
                    map.put("state","评论成功");
                    map.put("code",1);
                    map.put("comment",save);
                }else {
                    map.put("state","评论失败");
                    map.put("code",0);
                }
        System.out.println(map);
         return map;
    }

    @ResponseBody
    @GetMapping("good")
    public Map<String,Object> good(Integer cid){
        System.out.println("点了ID为："+cid);
        Map<String,Object> map=new HashMap<>();
        Comment byIdAndState = commentService.findByIdAndState(cid, 1);
         int cont= byIdAndState.getNiceComment();
        byIdAndState.setNiceComment(cont+1);
        System.out.println("点赞数"+cont);
        Comment save = commentService.saveComment(byIdAndState);
        map.put("comment",save);
        map.put("god",save.getNiceComment());
        return map;
    }

    @ResponseBody
    @GetMapping("delete")
    public Map<String,Object> deleteComm(Integer cid, HttpSession session){
        User user = (User)session.getAttribute("loginUser");
        Map<String,Object>map=new HashMap<>();
        Comment comment = commentService.findByIdAndState(cid, 1);
        if (user.getId().equals(comment.getUser().getId())){
            int delete = commentService.delete(cid);
            if (delete==0){
                map.put("state","删除成功");
            }else{
                map.put("state","删除失败");
            }
        }else {
            map.put("state","权限不足");
        }

        return map;
    }
}
