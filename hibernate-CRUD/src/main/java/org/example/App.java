package org.example;

import org.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class App 
{

    public static SessionFactory getSessionFactory(){

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class);
        SessionFactory sf = configuration.buildSessionFactory();

        return sf;
    }



    public static void create(Employee emp){

        Session session = getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save(emp);
        tr.commit();
        session.close();


    }

    public static void read(){

        Session session = getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        List<Employee> employeeList = session.createQuery("FROM Employee").list();
        tr.commit();
        session.close();

        for(Employee employee : employeeList){
            System.out.println(employee);
        }

    }

    public static void update(Employee e){

        Session session = getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Employee em = (Employee) session.load(Employee.class, e.getId());
        em.setName(e.getName());
        em.setDepartment(e.getDepartment());
        tr.commit();
        session.close();

    }


    public static void delete(int id){

        Session session = getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Employee em = (Employee) session.load(Employee.class, id);
        session.delete(em);
        tr.commit();
        session.close();
    }



    public static void main( String[] args ) {

        Employee emp = new Employee(1, "Nikhil", "ISE");

//        create(emp);

//        read();
//
//        update(emp);
//        read();

        delete(2);


    }
}
