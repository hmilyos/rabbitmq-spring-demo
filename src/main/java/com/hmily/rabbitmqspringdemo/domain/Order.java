package com.hmily.rabbitmqspringdemo.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;

    private String name;

    private String content;


}
