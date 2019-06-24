package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.User.UserServices;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-05 20:25
 **/
@Controller
public class IndexController {
    @Autowired
    private UserServices userServices;

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("login")
    public String login(){
        return "user/login";
    }

    @GetMapping("register")
    public String register(){

        return "user/register";
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }



    @PostMapping("login")
    public String login(String username, String password, Model model, HttpSession session){
        Map<String, Object> resultMap = userServices.login(username, password);
        if((Boolean) resultMap.get("ok")){
            //把登录成功后的用户对象保存到session中
            session.setAttribute("loginUser", resultMap.get("user"));
            return "redirect:/";
        }else{
            model.addAttribute("error", resultMap.get("error"));
            return "login";
        }
    }

    @PostMapping("register")
    public String register(String username,String password,String password2,String sex,String birthday,String email,Model model) {
        if (password.equals(password2)) {
            User user = new User();
            user.setCreateTime(new Date());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setBirthday(sdf.parse(birthday));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setPassword(password);
            user.setSex(sex);
            user.setEmail(email);
            user.setUsername(username);
            Map<String, Object> map = userServices.register(user);
            System.out.println(map.get("ok"));
            if ((Boolean)map.get("ok")) {
                model.addAttribute("恭喜您注册成功！");
                return "user/login";
            } else {
                model.addAttribute("error",map.get("error"));
                return "user/register";
            }
        } else {
            System.out.println("密码不相同");
            model.addAttribute("error", "亲亲！您输入的2次密码不相同哦！");
            return "user/register";
        }
    }
}
