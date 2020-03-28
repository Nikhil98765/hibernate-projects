package com.example.service;

import com.example.dao.CustomerDao;
import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    CustomerDao customerDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List listAllCustomers() {
        return customerDao.listAllCustomers();
    }

    public void saveOrUpdate(String name) {
        customerDao.saveOrUpdate(name);
    }

    public Customer findCustomerById(int id) {
        return customerDao.findCustomerById(id);
    }

    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }

    public void update(Customer customer, String name){
        customerDao.update(customer, name);
    }

}

