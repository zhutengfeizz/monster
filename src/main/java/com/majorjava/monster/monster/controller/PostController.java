package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.entity.user.*;
import com.majorjava.monster.monster.service.Post.CommentService;
import com.majorjava.monster.monster.service.Post.FieldService;
import com.majorjava.monster.monster.service.Post.PartitionService;
import com.majorjava.monster.monster.service.Post.PostService;
import com.majorjava.monster.monster.service.User.UserServices;
import com.majorjava.monster.monster.upload.UploadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private CommentService commentService;
    @Autowired
    private PostService postService;
    @Autowired
    private PartitionService partitionService;
    @Autowired
    private FieldService fieldService;
    @Resource
    private UploadProperties uploadProperties;
    @Autowired
    private UserServices userServices;

    @GetMapping("postList")
    public String allPost(Model model){
        List<Post> posts =(List<Post>) postService.postAll();
        model.addAttribute("allPost",posts);
        System.out.println(posts);
        return "admin/post/admin_post_list";
    }

    @GetMapping("deleteList")
    public String deleteList(Model model){
        List<Post> posts = postService.findBydelete();
        model.addAttribute("allPost",posts);
        return "admin/post/admin_post_list";
    }

    @GetMapping("save")
    public String addPost(Model model){
        Post post =new Post();
        model.addAttribute(post);
        //获取分区列表
        List<PostPartition> partitionList=partitionService.postPartitionAll();
        model.addAttribute("partitionList",partitionList);
        //获取领域列表
        List<PartitionField> partitionFields = fieldService.partitionFieldAll();
        model.addAttribute("partitionFields",partitionFields);
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
        }else {
            model.addAttribute("error","修改失败!id为空。");
        }
        return "admin/post/admin_post_edit";
    }
    @PostMapping("save")
    public String save(Integer id,String title,String type,
                       Integer field,String introduction,
                       String content,Integer partition,Integer uid,String img
    ){
        Post p=null;
        if (id!=null){
            p=postService.finByid(id);
            p.setName(title);
            p.setType(type);
            p.setContent(content);
            p.setImg(img);
            p.setIntroduction(introduction);
            PartitionField field1 = fieldService.finByid(field);
            p.setField(field1);
            PostPartition postPartition = partitionService.finByid(partition);
            p.setPartition(postPartition);
        }else {
            p =new Post();
            User user = userServices.finByid(uid);
            p.setImg(img);
            p.setUser(user);
            p.setName(title);
            p.setType(type);
            p.setCreateTime(new Timestamp(System.currentTimeMillis()));
            p.setIntroduction(introduction);
            p.setContent(content);
            PartitionField field1 = fieldService.finByid(field);
            p.setField(field1);
            PostPartition postPartition = partitionService.finByid(partition);
            p.setPartition(postPartition);
        }
        System.out.println(p);
        postService.save(p);
        return "redirect:/post/postList";
    }

    @GetMapping("delete")
    public String delete(Integer id){
        postService.delete(id);
        return "redirect:/post/deleteList";
    }

    @GetMapping("restore")
    public  String restore(Integer id){
        Post post = postService.finByid(id);
        post.setState(1);
       postService.save(post);
        return "redirect:/post/postList";
    }

    @GetMapping("finalDelete")
    public String finalDelete(Integer id){
        postService.finalDelete(id);
        return "redirect:/post/deleteList";
    }

    @ResponseBody
    @PostMapping("getField")
    public List<PartitionField> getField(Integer id){
        System.out.println("id:"+id);
        List<PartitionField> fieldList = fieldService.findByPartitionId(id);

            return fieldList;
    }

    @GetMapping("postEdit")
    public String postEdit(Model model,Integer id){
        List<Post> posts = postService.postAll();
        model.addAttribute("postList",posts);
        Post post = postService.finByid(id);
        model.addAttribute("post",post);

        return "post/post_edit";
    }
}
