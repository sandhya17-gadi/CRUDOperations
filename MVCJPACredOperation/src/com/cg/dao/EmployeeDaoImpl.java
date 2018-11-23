package com.cg.dao;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springmvcone.dto.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements IEmployeeDao {
     
	@PersistenceContext
	EntityManager entitymanager;
	
	@Override
	public int addEmployeeData(Employee emp) {
		// TODO Auto-generated method stub
		entitymanager.persist(emp);
	   entitymanager.flush();
		return emp.getEmpId();
	}

	@Override
	public List<Employee> showAllEmployee() {
		// TODO Auto-generated method stub
		Query query=entitymanager.createQuery("from Employee");
		List<Employee> myList=query.getResultList();
		return myList;
	}

	@Override
	public void deleteEmployee(int empId) {
		
		Query query=entitymanager.createQuery("delete from Employee where empId=:eid");
		query.setParameter("eid", empId);
		query.executeUpdate();
		  
		// TODO Auto-generated method stub
	

	}

	@Override
	public boolean updateEmployee(Employee emp) {
		
		try
		{
	entitymanager.merge(emp);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	   

      
       

	}

	@Override
	public Employee searchEmployee(int id) {
		// TODO Auto-generated method stub
		
		Employee emp=entitymanager.find(Employee.class, id);
		//System.out.println(emp);
		return emp;
	}

}
