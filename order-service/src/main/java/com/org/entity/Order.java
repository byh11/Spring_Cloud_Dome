package com.org.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int order_id;
    private int user_id;
    private String name;
    private int price;
    private User user;
}
