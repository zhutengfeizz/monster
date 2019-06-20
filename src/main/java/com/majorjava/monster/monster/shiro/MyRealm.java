package com.majorjava.monster.monster.shiro;

import com.majorjava.monster.monster.entity.user.User;
import com.majorjava.monster.monster.service.User.UserServices;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

//@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserServices userService;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取令牌
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        //从令牌中获取用户名
        String username = token.getUsername();
        //按用户名查询用户
        User user = userService.findByUsername(username);
        if(user!=null){
            //获取用户的盐
            String salt = user.getSalt();
            ByteSource saltBytes = ByteSource.Util.bytes(salt);

            //创建简单的认证信息对象
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), saltBytes, this.getName());
            return authenticationInfo;
        }
        return null;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登录用户
        User user = (User)principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        List<String> pmssList = new ArrayList<String>();
        if("zhangsan".equals(user.getUsername())){
            //添加角色
            authorizationInfo.addRole("student");
            pmssList.add("/user/profile/view");
            pmssList.add("/user/profile/edit");
            pmssList.add("/student/online_selection");
            pmssList.add("/user/pwd/update");
            pmssList.add("/message/leave");
            pmssList.add("/message/view");
        }else if("lisi".equals(user.getUsername())){
            authorizationInfo.addRole("teacher");
            pmssList.add("/teacher/teach_plan");
        }
        //添加权限
        authorizationInfo.addStringPermissions(pmssList);
        return authorizationInfo;
    }

}
