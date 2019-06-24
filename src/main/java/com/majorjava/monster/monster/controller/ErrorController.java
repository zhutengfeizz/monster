package com.majorjava.monster.monster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-24 10:05
 **/
@Controller
@RequestMapping()
public class ErrorController {
    @GetMapping
    public String error(){
        System.out.println("出现了一些小问题！");
        return "error/403";
    }

    @GetMapping("403")
    public String error403(){
        return "error/403";
    }
}
