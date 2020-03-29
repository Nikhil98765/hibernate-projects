package com.example.service;

import com.example.dao.AccountDao;
import com.example.dao.BranchDao;
import com.example.exceptions.LowBalanceException;
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

    public void saveOrUpdate(Double balance, int customer_id, int branch_id) {
        accountDao.saveOrUpdate(balance, customer_id, branch_id);
    }

    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    public void deleteAccount(int id) {
        accountDao.deleteAccount(id);
    }

    public void withdraw(Account account , Double amount) throws LowBalanceException {

        accountDao.withdraw(account, amount);

    }

    public void deposit(Account account, Double amount){
        accountDao.deposit(account, amount);
    }

}
