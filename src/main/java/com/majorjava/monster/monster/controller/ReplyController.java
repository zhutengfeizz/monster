package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.entity.user.Comment;
import com.majorjava.monster.monster.entity.user.Reply;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.Post.CommentService;
import com.majorjava.monster.monster.service.Post.ReplyService;
import com.majorjava.monster.monster.service.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>monster</h3>
 * <p>评论的回复</p>
 *
 * @author : ztf
 * @date : 2019-07-18 06:08
 **/
@Controller
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserServices userServices;
    @Autowired
    private ReplyService replyService;

    @ResponseBody
    @GetMapping("add")
    private Map<String,Object> comment(Integer uid, String content, Integer cid, String ip){
        System.out.println("ajax传过来的uid:"+uid+",帖子id："+cid+"评论的内容"+content+",传过来的ip是："+ip);
        User user = userServices.finByid(uid);
        Comment post = commentService.findByIdAndState(cid,1);
        Map<String,Object> map=new HashMap<>();
        Comment save = commentService.save(uid, cid, content,ip);
        if (save!=null){
            map.put("state","回复评论成功");
            map.put("code",1);
            map.put("reply",save);
        }else {
            map.put("state","回复评论失败");
            map.put("code",0);
        }
        System.out.println(map);
        return map;
    }

    @ResponseBody
    @GetMapping("good")
    public Map<String,Object> good(Integer rid){
        System.out.println("点了ID为："+rid);
        Map<String,Object> map=new HashMap<>();
        Reply byId = replyService.findById(rid);
        byId.setAwesome(byId.getAwesome()+1);
        System.out.println("点赞数"+byId.getAwesome());
        Reply save = replyService.save(byId);
        map.put("reply",save);
        map.put("god",save.getAwesome());
        return map;
    }
}
