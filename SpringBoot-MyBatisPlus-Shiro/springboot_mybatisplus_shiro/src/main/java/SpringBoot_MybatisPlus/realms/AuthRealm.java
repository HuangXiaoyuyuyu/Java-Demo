package SpringBoot_MybatisPlus.realms;


import SpringBoot_MybatisPlus.bean.Menu;
import SpringBoot_MybatisPlus.bean.Role;
import SpringBoot_MybatisPlus.bean.User;
import SpringBoot_MybatisPlus.service.UserService;
import SpringBoot_MybatisPlus.utils.Encodes;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.http2.ByteUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String loginName = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.findUserByLoginName(loginName);
        Set<Role> roles = user.getRoles();
        Set<String> roleNames = new HashSet<>();
        Set<String> permission = new HashSet<>();
        if (roles.size() > 0) {
            for (Role role : roles) {
                if (StringUtils.isNotBlank(role.getRname())) {
                    roleNames.add(role.getRname());
                    Set<Menu> menus = role.getMenus();
                    if (menus.size() > 0) {
                        for (Menu menu : menus) {
                            if (StringUtils.isNotBlank(menu.getMname())) {
                                permission.add(menu.getMname());
                            }
                        }
                    }
                }
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roleNames);
        simpleAuthorizationInfo.setStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String loginName = (String) token.getPrincipal();
        Object principal = loginName;
        User user = userService.findUserByLoginName(loginName);

        System.out.println(user);
        System.out.println("roles follows:");
        user.getRoles().forEach(System.out::println);
        System.out.println("menus follows:");
        for (Role role : user.getRoles()) {
            role.getMenus().forEach(System.out::println);
        }

        System.out.println(loginName);
        System.out.println(token.getPassword());

        byte[] salt = Encodes.decodeHex(user.getSalt());
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                principal,user.getPassword(),ByteSource.Util.bytes(salt),getName());
        return simpleAuthenticationInfo;
    }
}
