package com.majorjava.monster.monster.service.impl.User;

import com.majorjava.monster.monster.dao.UserDao;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.User.UserServices;
import com.majorjava.monster.monster.shiro.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;

/**
 * <h3>monster</h3>
 * <p>${description}</p>
 *
 * @author : ztf
 * @date : 2019-06-05 19:35
 **/
@Service
@Transactional
public class UserServicesImpl implements UserServices {
@Autowired
 private UserDao userDao;

    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String,Object> map =new HashMap<String, Object>();
        map.put("ok",false);
        //shiro认证
        Subject subject = SecurityUtils.getSubject();
        //创建shiro令牌
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
    try {
        subject.login(token);
        map.put("ok",true);
        //从subject中获取当前登录用户的对象
        User user =(User)subject.getPrincipal();
        map.put("user",user);
       /* System.out.println("username=="+user.getUsername());*/
    }catch (UnknownAccountException e){
        e.printStackTrace();
        map.put("error","登录失败！用户不存在！");
    }catch (IncorrectCredentialsException e){
        e.printStackTrace();
        map.put("error","登录失败！密码错误！");
    }catch (Exception e){
        e.printStackTrace();
        map.put("error","登录失败！未知错误！");
    }
        return map;
    }

    @Override
    public Map<String, Object> register(User user) {
        Map<String ,Object>map=new HashMap<String, Object>();
        map.put("ok",false);
        User user1 = userDao.findByUsername(user.getUsername());
        if (user1==null){
            User user2=new User();
            user2.setUsername(user.getUsername());
            String salt = ShiroUtil.createSalt();
            String pwdBySalt = ShiroUtil.createPwdBySalt(user.getPassword(), salt);
            user2.setPassword(pwdBySalt);
            user2.setEmail(user.getEmail());
            user2.setSex(user.getSex());
            user2.setBirthday(user.getBirthday());
            user2.setSalt(salt);
            user2.setCreateTime(new Timestamp(System.currentTimeMillis()));
            user2.setState(1);
            user2.setAge(18);
            String nurl="/user/"+"a4d244e8-550c-4875-908f-fea99cce8f54.png";
            String nvrl="/user/"+"e0406002-b9c4-45b5-ba66-10e2e6d4ea06.png";
            if (user2.getSex()=="男"||user.getSex().equals("男")){
                System.out.println("男");
                user2.setHeadshot(nurl);
                System.out.println("设置头像："+nurl);
            }
            if (user2.getSex()=="女"||user.getSex().equals("女")){
                System.out.println("女");
                user2.setHeadshot(nvrl);
            }

            User save = userDao.save(user2);
            if (save!=null){
                map.put("ok",true);
            }else {
                map.put("error","注册失败！");
            }
        }else {
            map.put("error","该用户名已被注册！");
        }
        return map;
    }

    @Override
    public User save(User user) {
        User save = userDao.save(user);
        return save;
    }

    @Override
    public void delete(Integer id) {
        User user = userDao.findById(id).get();
        user.setState(0);
        userDao.save(user);
    }

    @Override
    public User finByid(Integer id) {
        User user = userDao.findById(id).get();
        return user;
    }

    @Override
    public User update(User user) {
        User save = userDao.save(user);
        return save;
    }


    @Override
    public List<User> findAll() {
        List<User> users =(List<User>) userDao.findByStateOrderByCreateTimeDesc(1);
        return users;
    }

    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        System.out.println("UserServiceImpl"+user.getUsername());
        return user;
    }

    @Override
    public List<User> findBydelete() {
        List<User> users =(List<User>) userDao.findByStateOrderByCreateTimeDesc(0);
        return users;
    }

    @Override
    public void finalDelete(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public User updateheadshot(Integer uid, String headshot) {

        User user = userDao.findById(uid).get();
        user.setHeadshot("/user/"+headshot);

        return userDao.save(user);
    }

    @Override
    public List<User> findByUsernameLikeAndStateOrderByCreateTimeDesc(String username, int state) {
        return userDao.findByUsernameLikeAndStateOrderByCreateTimeDesc(username,state);
    }

    @Override
    public User findByUsernameLike(String username) {
        return userDao.findByUsernameLike(username);
    }
}
