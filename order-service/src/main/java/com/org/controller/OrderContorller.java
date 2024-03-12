package com.org.controller;

import com.org.entity.Order;
import com.org.service.OrderServiceimpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderContorller {


    @Autowired
    private OrderServiceimpl orderServiceimpl;

    @RequestMapping("/order")
    @ResponseBody
    public Order order(@Param("id") int id){
        Order order=orderServiceimpl.selectById(id);
        System.out.println(order);
        return order;
    }
}
