package com.example.dao;

import com.example.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Customer> listAllCustomers() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return criteria.list();
    }

    public void saveOrUpdate(Customer customer) {
        getSession().saveOrUpdate(customer);
    }

    public Customer findCustomerById(int id) {
        return (Customer) getSession().get(Customer.class, id);
    }

    public void deleteCustomer(int id) {
        Customer customer = (Customer) getSession().get(Customer.class, id);
        getSession().delete(customer);
    }
}
