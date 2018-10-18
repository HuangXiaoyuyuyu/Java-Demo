package org.hxy.service;

import org.hxy.bean.UserAddress;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        //OrderService orderService = (OrderService) context.getBean("orderService"); // 获取远程服务代理
        //List<UserAddress> list = orderService.initOrder("1");// 执行远程方法
        //list.forEach(System.out::println); // 显示调用结果
        System.in.read(); // 按任意键退出

    }
}
