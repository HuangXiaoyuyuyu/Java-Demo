package org.hxy.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.hxy.ticket.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public void getTicket() {
        System.out.println("123123123");
        String ticket = ticketService.getTicket();
        System.out.println("买到票了：" + ticket);
    }

}
