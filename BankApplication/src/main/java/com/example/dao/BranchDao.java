package com.example.dao;

import com.example.model.Branch;
import com.example.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BranchDao {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public List<Branch> listAllBranches() {
        Criteria criteria = getSession().createCriteria(Branch.class);
        return criteria.list();
    }

    public void saveOrUpdate(Branch branch) {
        getSession().saveOrUpdate(branch);
    }

    public Branch findBranchById(int id) {
        return (Branch) getSession().get(Branch.class, id);
    }

    public void deleteBranch(int id) {
        Branch branch = (Branch) getSession().get(Branch.class, id);
        getSession().delete(branch);
    }
}
