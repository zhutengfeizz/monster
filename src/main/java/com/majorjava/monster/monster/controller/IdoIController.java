package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.entity.user.Idol;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.User.IdolServices;
import com.majorjava.monster.monster.service.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>monster</h3>
 * <p>关注</p>
 *
 * @author : ztf
 * @date : 2019-07-13 18:15
 **/
@Controller
@RequestMapping("/idol")
public class IdoIController {
    @Autowired
    private UserServices userServices;
    @Autowired
    private IdolServices idolServices;

    @ResponseBody
    @GetMapping("addIdol")
    public Map<String,Object> save(Integer uid , Integer beUid, Model model){
        System.out.println("uid"+uid+",beUid"+uid);
        Map<String,Object>map=new HashMap<>();
        Idol idol1 = idolServices.findByBeUserIdAndUserId(beUid, uid);
        System.out.println("检查是否关注过："+idol1);
        if (idol1==null){
            System.out.println("没关注过！添加关注！");
                User user = userServices.finByid(beUid);
            System.out.println("判断被关注的用户是否为空："+user);
                user.setFanSize(user.getFanSize()+1);
                userServices.save(user);
                User user1 = userServices.finByid(uid);
                user1.setFollowSize(user1.getFollowSize()+1);
                userServices.save(user1);
            Idol add = idolServices.add(uid, beUid);
            System.out.println("添加的对象为："+add+",添加了点击关注的人是："+add.getUser().getUsername()+",添加了被关注的人是："+add.getBeUser().getUsername());
            if (add==null){
                    map.put("error","关注失败！");
                }else {
                    System.out.println(add.getUser().getUsername()+",这个逼刚才关注了"+add.getBeUser().getUsername());
                     map.put("error","1");
                }
        }else {
            idolServices.delete(idol1);
            System.out.println("取消关注成功！");
            User user = userServices.finByid(beUid);
             user.setFanSize(user.getFanSize()-1);
             userServices.save(user);
            User user1 = userServices.finByid(uid);
            user1.setFollowSize(user1.getFollowSize()-1);
            userServices.save(user1);
            map.put("error","取消关注成功！");
        }
        System.out.println("这是MAP里面的值"+map.get("error"));
       return map;
    }
    @ResponseBody
    @GetMapping("getGz")
    public Map<String,Object>getGz(Integer uid,Integer beUid){
        System.out.println("是否关注过："+uid+","+beUid);
        Map<String,Object> map=new HashMap<>();
        Idol byBeUserIdAndUserId = idolServices.findByBeUserIdAndUserId(beUid, uid);
        if (byBeUserIdAndUserId==null){
            map.put("code",'0');
        }else {
            map.put("code",'1');
        }
        return map;
    }

    @GetMapping("delete")
    public String delete(Integer id,Model model){
        if (id!=null){
            Idol byId = idolServices.findById(id);
            idolServices.delete(byId);
            model.addAttribute("error","删除成功");
            System.out.println("删除成功");
        }else {
            model.addAttribute("error","取消关注失败！id为空");
            System.out.println("取消关注失败!该收藏不存在！");
        }
        return "";
    }

}
