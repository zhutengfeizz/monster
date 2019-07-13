package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.service.User.IdolServices;
import com.majorjava.monster.monster.service.User.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private IdolServices services;

}
