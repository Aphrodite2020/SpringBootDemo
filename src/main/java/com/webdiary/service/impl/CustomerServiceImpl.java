package com.webdiary.service.impl;

import com.webdiary.entity.Customer;
import com.webdiary.mapper.CustomerMapper;
import com.webdiary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 56835 on 2020-05-20.
 */
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerMapper customerMapper;
    @Override
    public Customer getCustomerByName(String customerName) {
        return customerMapper.selectByCustomerName(customerName);
    }
}
