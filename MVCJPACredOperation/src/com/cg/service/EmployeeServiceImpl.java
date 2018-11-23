package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IEmployeeDao;
import com.cg.springmvcone.dto.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService{

	
	@Autowired
	IEmployeeDao employeeDao;
	
	@Override
	public int addEmployeeData(Employee emp) {
		// TODO Auto-generated method stub
		return employeeDao.addEmployeeData(emp);
	}

	@Override
	public List<Employee> showAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.showAllEmployee();
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		
		return employeeDao.updateEmployee(emp);
	}

	@Override
	public Employee searchEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDao.searchEmployee(id);
	}

	

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		
		employeeDao.deleteEmployee(empId);
	}
	
	

}
