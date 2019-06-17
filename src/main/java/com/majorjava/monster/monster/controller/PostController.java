package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-15 10:23
 **/
@Controller
public class PostController {
    @Autowired
  private PostMapper postMapper;

    @PostMapping("allPost")
    public String allPost(Model model){
        List<Post> postList = postMapper.findAll();
        model.addAttribute(postList);
        return "admin_post_list";
    }
}
