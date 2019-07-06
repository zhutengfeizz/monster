package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.Post.PostService;
import com.majorjava.monster.monster.service.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    @Autowired
    private PostService postService;

    @GetMapping("index")
    public String index(HttpSession session,Model model){
        List<Post> postList = postService.postAll();
        model.addAttribute("postList",postList);
        User loginUser = (User)session.getAttribute("loginUser");
        if(loginUser!=null){
            session.setAttribute("loginUser",userServices.finByid(loginUser.getId()));
        }

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
        return "redirect:/index";
    }



    @PostMapping("login")
    public String login(String username, String password, Model model, HttpSession session, RedirectAttributes redirectAttributes){
        Map<String, Object> resultMap = userServices.login(username, password);
        if((Boolean) resultMap.get("ok")){
            //把登录成功后的用户对象保存到session中
          User user= (User)resultMap.get("user");
            session.setAttribute("loginUser", user);
            System.out.println("头像是："+user.getHeadshot());
            System.out.println(user.getUsername()+"pasword"+user.getPassword());
            return "redirect:/index";
        }else{
            model.addAttribute("error", resultMap.get("error"));
            return "user/login";
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
    @GetMapping("myHome")
    public String myHome(Integer id,Model model){
        User user = userServices.finByid(id);
        model.addAttribute("user",user);
        return "user/myHome";
    }
}
