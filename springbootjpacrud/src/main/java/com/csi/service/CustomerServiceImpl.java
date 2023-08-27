package com.csi.service;

import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerServiceImpl {

    @Autowired
    CustomerDaoImpl customerDaoImpl;

    public Customer signUp(Customer customer){
        return customerDaoImpl.signUp(customer);
    }

    public boolean signIn(String custEmailId, String custPassword){
        return customerDaoImpl.signIn(custEmailId, custPassword);
    }

    @Cacheable(value = "custId")
    public Optional<Customer> getDataById(int custId){
        log.info("@@@@@Trying to fetch data from DB");
        return customerDaoImpl.getDataById(custId);
    }

    public List<Customer> getDataByCustName(String custName){
        return customerDaoImpl.getDataByCustName(custName);
    }

    public List<Customer> getAllData(){
        return customerDaoImpl.getAllData();
    }

    public Customer updateData(Customer customer){
        return customerDaoImpl.updateData(customer);
    }

    public void deleteDataById(int custId){
        customerDaoImpl.deleteDataById(custId);
    }
}
