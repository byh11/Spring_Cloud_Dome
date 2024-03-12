package com.org.service;

import com.org.clients.UserClient;
import com.org.entity.Order;
import com.org.entity.User;
import com.org.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceimpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;
    @Override
    public Order selectById(int id) {
        Order order = orderMapper.selectById(id);
//        order.setUser(restTemplate.getForObject("http://user-service/user?id="+order.getUser_id(), User.class));
        order.setUser(userClient.findById(order.getUser_id()));
        return order;
    }
}
