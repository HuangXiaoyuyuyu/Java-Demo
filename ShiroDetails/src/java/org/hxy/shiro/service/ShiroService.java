package org.hxy.shiro.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import java.util.Date;

public class ShiroService {

    @RequiresRoles({"admin"})
    public void testShiroAnnotation() {
        Session session = SecurityUtils.getSubject().getSession();
        Object val = session.getAttribute("key");
        System.out.println("Service Session:" + val);
        System.out.println("Test ShiroAnnotation,time: " + new Date());
    }

}
