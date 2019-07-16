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
    public Map save(Integer uid , Integer beUid, Model model){
        Map<String,Object>map=new HashMap<>();
        System.out.println("关注用户功能：传过来的用户ID为--"+uid+"，关注的ID为："+beUid);
        Idol idol1 = idolServices.findByBeUserIdAndUserId(beUid, uid);
        if (idol1==null){
            System.out.println("根据:用户ID和关注的ID查找不到对象！");
        }else {

            System.out.println("查到值并输入当前用户的用户名:"+ idol1.getUser().getUsername());
            System.out.println("根据:用户ID和关注的ID查找不到对象！");
        }
        System.out.println("idol1:----------------------------------------------------"+idol1.getId());
            if (idol1==null){
                Idol add = idolServices.add(uid, beUid);
                if (add==null){
                    System.out.println(add.getUser().getUsername()+",这个逼刚才关注了"+add.getBeUser().getUsername());
                    model.addAttribute("status",0);
                }else {
                    System.out.println(add.getUser().getUsername()+",这个逼刚才关注了"+add.getBeUser().getUsername());
                    model.addAttribute("status",1);
                }
            return map;
        }else {
            idolServices.delete(idol1);
            model.addAttribute("status",2);
            System.out.println("取消关注成功！");
            User user = userServices.finByid(beUid);
             user.setFanSize(user.getFanSize()-1);
             userServices.save(user);
            User user1 = userServices.finByid(uid);
            user1.setFollowSize(user1.getFollowSize()-1);
            userServices.save(user1);
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
