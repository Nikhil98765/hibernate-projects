package org.example;

import org.example.dao.EmployeeDao;
import org.example.model.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);

        Employee employee = new Employee();
        employee.setName("Nikhita");
        employee.setId(1);
        employee.setDepartment("ISE");

        employeeDao.update(employee);

        employeeDao.delete(2);

        List<Employee> list = employeeDao.list();

        for(Employee p : list){
            System.out.println("Employee List::"+p);
        }

        context.close();
    }
}
