package com.example.service;

import com.example.dao.AccountDao;
import com.example.dao.BranchDao;
import com.example.model.Account;
import com.example.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {

    AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List listAllAccounts() {
        return accountDao.listAllAccounts();
    }

    public void saveOrUpdate(Account account) {
        accountDao.saveOrUpdate(account);
    }

    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    public void deleteAccount(int id) {
        accountDao.deleteAccount(id);
    }
}
