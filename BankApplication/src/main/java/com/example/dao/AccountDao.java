package com.example.dao;

import com.example.model.Account;
import com.example.model.Branch;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDao {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Account> listAllAccounts() {
        Criteria criteria = getSession().createCriteria(Account.class);
        return criteria.list();
    }

    public void saveOrUpdate(Account account) {
        getSession().saveOrUpdate(account);
    }

    public Account findAccountById(int id) {
        return (Account) getSession().get(Account.class, id);
    }

    public void deleteAccount(int id) {
        Account account = (Account) getSession().get(Account.class, id);
        getSession().delete(account);
    }
}
