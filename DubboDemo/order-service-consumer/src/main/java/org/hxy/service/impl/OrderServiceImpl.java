package org.hxy.service.impl;

import org.hxy.bean.UserAddress;
import org.hxy.service.OrderService;
import org.hxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        return userService.getUserAddressList(userId);
    }
}
