package com.webdiary.service;

import com.webdiary.entity.Customer;

/**
 * Created by 56835 on 2020-05-20.
 */
public interface CustomerService {
    Customer getCustomerByName(String customerName);
}
