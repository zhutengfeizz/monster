package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-11 17:32
 **/
@Controller
public class AdminController {
    @Autowired
    private UserServices userServices;

    @GetMapping("adminIndex")
    public String index(){

        return "admin/admin_index";
    }

 /*   @GetMapping("userList")
    public String userList(Model model){
        List<User> userList = userServices.userFinall();
        model.addAttribute("UserList",userList);
        return "admin/admin_user_list";
    }*/
}
