package com.csi.dao;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDaoImpl {

    @Autowired
    CustomerRepo customerRepoImpl;

    public Customer signUp(Customer customer){
        return customerRepoImpl.save(customer);
    }

    public boolean signIn(String custEmailId, String custPassword){
        boolean flag = false;
        for(Customer customer : getAllData()){
            if (customer.getCustEmailId().equals(custEmailId) && customer.getCustPassword().equals(custPassword)){
                flag = true;
            }
        }
        return flag;
    }

    public Optional<Customer> getDataById(int custId){
        return customerRepoImpl.findById(custId);
    }

    public List<Customer> getDataByCustName(String custName){
        return customerRepoImpl.findByCustName(custName);
    }

    public List<Customer> getAllData(){
        return customerRepoImpl.findAll();
    }

    public Customer updateData(Customer customer){
        return customerRepoImpl.save(customer);
    }

    public void deleteDataById(int custId){
        customerRepoImpl.deleteById(custId);
    }

}
