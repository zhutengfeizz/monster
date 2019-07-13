package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.entity.user.Idol;
import com.majorjava.monster.monster.service.User.IdolServices;
import com.majorjava.monster.monster.service.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("addIdol")
    public String save(Integer uid , Integer beUid, Model model){
        Idol idol=null;
        Idol idol1 = idolServices.findByBeUserIdAndUserId(beUid, uid);
        if (idol1==null){
            if (uid!=null||beUid!=null){
                idol = idolServices.add(uid, beUid);
            }else {
                model.addAttribute("error","关注失败！");
            }
            if (idol.equals("")||idol==null){
                model.addAttribute("error","关注失败!");
            }else {
                model.addAttribute("error","关注成功！");
            }
            return "";
        }else {
            idolServices.delete(idol1);
            model.addAttribute("error","取消关注成功!");
        }
       return "";
    }

    @GetMapping("delete")
    public String delete(Integer id,Model model){
        if (id!=null){
            Idol byId = idolServices.findById(id);
            idolServices.delete(byId);
            model.addAttribute("error","删除成功");
        }else {
            model.addAttribute("error","取消关注失败！id为空");
        }
        return "";
    }

}
