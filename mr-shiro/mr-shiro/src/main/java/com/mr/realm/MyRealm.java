package com.mr.realm;

import com.mr.model.User;
import com.mr.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.zookeeper.data.Id;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.util.Password;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/25.
 */
public class MyRealm extends AuthorizingRealm{

    /**
     * 获取当前realm名
     * @return
     */
    @Autowired
    private UserService userService;

    @Override
    public String getName() {
        return "MyRealm";
    }

    // 授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获取当前对象
        User user = (User)principalCollection.getPrimaryPrincipal();

        //通过用户查询相对应的权限和角色
        //模拟
        //定义权限集合

        List<String> Permissions = userService.selectPermissionIdByUserId(user.getId());

      /*  Permissions.add("employee:save");
        Permissions.add("employee:list");
        Permissions.add("department:list");*/

        //角色
        List<String> roles = userService.selectRolesByUserId(user.getId());
       //  roles.add("admin");


        SimpleAuthorizationInfo info =new  SimpleAuthorizationInfo();

        //将权限放入info中
        info.addStringPermissions(Permissions);

        info.addRoles(roles);
        //将角色放入info中
        return info;
    }


    // 认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /**
         * 获取用户名
         */
       // String username = (String) token.getCredentials();

       UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        String username = token1.getUsername();
        System.out.println(username);
        /**
         * 通过用户名查询
         */
      User user =   userService.getUserByUserName(username);

      if(user==null){
          return null;
      }
        // 三个参数 当前用户，数据库中查询出来的密码 当前realm的名字
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(username),getName());
        System.out.println(info.getCredentialsSalt().getBytes().clone());
      return info;
    }

    //清除缓存，修改角色和权限之后，需要手动清除
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
