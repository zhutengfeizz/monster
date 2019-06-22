package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.entity.user.PartitionField;
import com.majorjava.monster.monster.entity.user.Post;
import com.majorjava.monster.monster.entity.user.PostPartition;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.Post.FieldService;
import com.majorjava.monster.monster.service.Post.PartitionService;
import com.majorjava.monster.monster.service.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-15 10:23
 **/
@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PartitionService partitionService;
    @Autowired
    private FieldService fieldService;

    @GetMapping("postList")
    public String allPost(Model model){
        List<Post> posts =(List<Post>) postService.postAll();
        model.addAttribute("allPost",posts);
        return "admin/post/admin_post_list";
    }

    @GetMapping("save")
    public String addPost(){
        return "/admin/post/admin_post_edit";
    }

    @GetMapping("edit")
    public String edit(Integer id,Model model){
        if (id!=null){
            Post post = postService.finByid(id);
            model.addAttribute("post",post);
            //获取分区列表
            List<PostPartition> partitionList=partitionService.postPartitionAll();
            model.addAttribute("partitionList",partitionList);
            //获取领域列表
            List<PartitionField> partitionFields = fieldService.partitionFieldAll();
            model.addAttribute("partitionFields",partitionFields);
        }else {
            model.addAttribute("error","修改失败!id为空。");
        }

        return "admin/post/admin_post_edit";
    }
    @PostMapping("save")
    public String save(Integer id,String title,String type,String quiz2,String introduction,String content,String quiz1,Integer uid){
        Post post=new Post();
        post.setName(title);
        post.setType(type);
        post.setCreateTime(new Timestamp(System.currentTimeMillis()));
        post.setIntroduction(introduction);
        post.setContent(content);
        post.setSort(quiz2);
        post.setRegion(quiz1);
        post.setImg(post.getImg());
        postService.update(post);
        return "redirect:/post/postList";
    }
    @GetMapping("delete")
    public String delete(Integer id){
        postService.delete(id);
        return "redirect:/post/postList";
    }
}
