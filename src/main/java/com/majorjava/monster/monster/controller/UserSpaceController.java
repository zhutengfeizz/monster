/*
package com.majorjava.monster.monster.controller;

import com.majorjava.monster.monster.dao.FollowersAndFans.UserRepository;
import com.majorjava.monster.monster.entity.FollowersAndFans.Relationship;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.FollowersAndFans.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

*/
/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-20 15:24
 **//*

@RequestMapping("/manage")
@Controller
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")  // 指定角色权限才能操作方法
public class UserSpaceController extends BaseController {
    @Autowired
    private RelationshipService relationshipService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/relationships")
    public String relationships() {
        return "forward:/manage/relationships/follows";
    }
    //粉丝-关注 start
    */
/**
     * 我的关注者列表
     * @param userId
     * @param optType
     * @return
     *//*

    @GetMapping("/relationships/follows")
    public ModelAndView follows(
            @RequestParam(value = "async", required = false) boolean async,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "size", defaultValue = "1", required = false) Integer size,
            Model model) {
        Long startTime = System.currentTimeMillis();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<User> userPage = relationshipService.listFollows(user.getId(), pageRequest);
        List<Integer> friendIds = relationshipService.listFriends(user.getId());
        List<User> userList = userPage.getContent();
        for (int i = 0; i < userList.size(); i++) {
            if (friendIds.contains(userList.get(i).getId())) {
                userPage.getContent().get(i).setIsFriend(2);
            }
        }
        model.addAttribute("userPage", userPage);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - startTime) + "ms");
        model.addAttribute("is_follows", true);
        return new ModelAndView(async == true ? "home/userspace/relationship :: .tab-pane" : "home/userspace/relationship");
    }
   */
/**
    * 2019/6/20
    * 描述一下方法的作用
    *我的粉丝列表
    * @author ztf
    * @return org.springframework.web.servlet.ModelAndView
    *//*

    @GetMapping("/relationships/fans")
    public ModelAndView fans(
            @RequestParam(value = "async", required = false) boolean async,
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "size", defaultValue = "1", required = false) Integer size,
            Model model) {
        Long startTime = System.currentTimeMillis();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<User> userPage = relationshipService.listFans(user.getId(), pageRequest);
        List<Integer> friendIds = relationshipService.listFriends(user.getId());
        List<User> userList = userPage.getContent();
        for (int i = 0; i < userList.size(); i++) {
            if (friendIds.contains(userList.get(i).getId())) {
                userPage.getContent().get(i).setIsFriend(2);
            }
        }
        model.addAttribute("userPage", userPage);
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - startTime) + "ms");
        model.addAttribute("is_fans", "true");
        return new ModelAndView(async == true ? "home/userspace/relationship :: .tab-pane" : "home/userspace/relationship");
    }
    */
/**
     * 添加关系
     * @param userId
     * @param optType
     * @return
     *//*

    @PostMapping("/relationships")
    public ResponseEntity<Response> followUser(Integer userId, String optType) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //1、判断用户是否存在
        User temp = userRepository.findById(userId).get();
        if (temp == null) {
            return ResponseEntity.ok().body(new Response(false, "用户不存在"));
        }
        //2、判断是关注还是取消关注
        //关注
        if ("follow".equals(optType)) {
            relationshipService.saveRelationship(new Relationship(user.getId(), userId));
        } else if ("notfollow".equals(optType)) {
            //取消关注
            relationshipService.removeRelationship(new Relationship(user.getId(), userId));
        } else {
            //非法操作
            return ResponseEntity.ok().body(new Response(false, "非法操作"));
        }
        Integer fanSize = userRepository.findById(userId).get().getFanSize();
        return ResponseEntity.ok().body(new Response(true, "操作成功",fanSize));
    }
    //粉丝-关注 end
}
*/
