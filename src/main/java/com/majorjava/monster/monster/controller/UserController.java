package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.User.UserServices;
import com.majorjava.monster.monster.upload.UploadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-05 19:58
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @Resource
    private UploadProperties uploadProperties;

    @GetMapping("/userList")
      public String list(Model model){
          List<User> userList = userServices.findAll();
          model.addAttribute("userList",userList);
          return "admin/user/admin_user_list";
      }

    @GetMapping("/duserList")
    public String listByDelete(Model model){
        List<User> userList = userServices.findBydelete();
        model.addAttribute("userList",userList);
        return "admin/user/admin_user_list";
    }

      @GetMapping("/edit")
      public String edit(Integer id,Model model){
        User user=null;
        if (id==null){
            user=new User();
        }else {
            user=userServices.finByid(id);
        }
        model.addAttribute("user",user);
        return "admin/user/admin_user_edit";
    }

      @PostMapping("/save")
      public String sava(int age,Integer id,RedirectAttributes redirectAttributes, String username, String password, String password2, String sex, String birthday, String email, Model model){
            User user=null;
            if (id==null){
                user=new User();
                user.setUsername(username);
                user.setPassword(password);
                String s = UUID.randomUUID().toString().replaceAll("-", "");
                user.setSalt(s);
                user.setSex(sex);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    user.setBirthday(sdf.parse(birthday));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                user.setCreateTime(new Timestamp(System.currentTimeMillis()));
            }else {
                user=userServices.finByid(id);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    user.setBirthday(sdf.parse(birthday));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                user.setAge(age);
                user.setEmail(email);
                user.setSex(sex);
            }
           user = userServices.add(user);
          redirectAttributes.addFlashAttribute("message","保存用户成功！");
          return "redirect:/user/userList";
      }

    @GetMapping("/delete")
    public String delete(Integer id, RedirectAttributes redirectAttributes){
        User user = userServices.finByid(id);
        user.setState(1);
        userServices.add(user);
        redirectAttributes.addFlashAttribute("message","删除用户成功！");
        return "redirect:/user/userList";
    }
}
