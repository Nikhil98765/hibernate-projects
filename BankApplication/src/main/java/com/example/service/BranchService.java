package com.example.service;

import com.example.dao.BranchDao;
import com.example.dao.CustomerDao;
import com.example.model.Branch;
import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BranchService {
    BranchDao branchDao;

    @Autowired
    public void setBranchDao(BranchDao branchDao) {
        this.branchDao = branchDao;
    }

    public List listAllBranches() {
        return branchDao.listAllBranches();
    }

    public void saveOrUpdate(Branch branch) {
        branchDao.saveOrUpdate(branch);
    }

    public Branch findBranchById(int id) {
        return branchDao.findBranchById(id);
    }

    public void deleteBranch(int id) {
        branchDao.deleteBranch(id);
    }
}
