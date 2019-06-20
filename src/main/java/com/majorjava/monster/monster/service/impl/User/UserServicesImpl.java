package com.majorjava.monster.monster.service.impl.User;

import com.majorjava.monster.monster.dao.UserDao;
import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.mapper.UserMapper;
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

@Autowired
private UserMapper userMapper;
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
    public User add(User user) {
        User save = userDao.save(user);
        return save;
    }

    @Override
    public void delete(Long id) {
        User user = userDao.findById(id).get();
        user.setState(0);
        userDao.save(user);
    }

    @Override
    public User finByid(Long id) {
        User user = userDao.findById(id).get();
        return user;
    }

    @Override
    public User update(User user) {
        User save = userDao.save(user);
        return save;
    }

    @Override
    public List<User> userFinall () {
        List<User> users =(List<User>) userDao.findAll();
        return users;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userMapper.findAll();
        return userList;
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> findBydelete() {
        List<User> userList = userMapper.findBydelete();
        return userList;
    }
}
