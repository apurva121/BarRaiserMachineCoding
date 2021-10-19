package com.example.springboot.model;

import lombok.Data;

import java.util.Set;

@Data
public class Customer {

    int id;
    int name;
    Set<Long> dealId;

}
