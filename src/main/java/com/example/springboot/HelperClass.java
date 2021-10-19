package com.example.springboot;

import com.example.springboot.model.Customer;

import java.util.Map;

public final class HelperClass {

    public static Map<Integer, Customer> customerMap;

    public void addCustomer(Customer customer){
        this.customerMap.put(customer.getId(), customer);
    }

    public Customer getACustomer(int customerId) {
        return customerMap.get(customerId);
    }

}
