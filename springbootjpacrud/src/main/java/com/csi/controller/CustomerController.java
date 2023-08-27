package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
// this is controller class
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@Valid @RequestBody Customer customer){
        return new ResponseEntity<>(customerServiceImpl.signUp(customer), HttpStatus.CREATED);
    }

    @GetMapping("/signin/{custEmailId}/{custPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String custEmailId, @PathVariable String custPassword){
        return ResponseEntity.ok(customerServiceImpl.signIn(custEmailId, custPassword));
    }

    @GetMapping("/getdatabyid")
    public ResponseEntity<Optional<Customer>> getDataById(@RequestParam int custId){
        return ResponseEntity.ok(customerServiceImpl.getDataById(custId));
    }

    @GetMapping("/getdatabyname")
    public ResponseEntity<List<Customer>> getDataByCustName(@RequestParam String custName){
        return ResponseEntity.ok(customerServiceImpl.getDataByCustName(custName));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Customer>> getAllData(){
        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @PutMapping("/updatedata")
    public ResponseEntity<Customer> updateData(@RequestParam int custId, @Valid @RequestBody Customer customer){

        Customer customer1 = customerServiceImpl.getDataById(custId).orElseThrow(()-> new RecordNotFoundException("Customer Id does not exists"));

        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustAccountBalance(customer.getCustAccountBalance());
        customer1.setCustDOB(customer.getCustDOB());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustPassword(customer.getCustPassword());

        return new ResponseEntity<>(customerServiceImpl.updateData(customer1), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletedatabyid")
    public ResponseEntity<String> deleteDataById(@RequestParam int custId){
        customerServiceImpl.deleteDataById(custId);
        return ResponseEntity.ok("Data deleted successfully");
    }
}
