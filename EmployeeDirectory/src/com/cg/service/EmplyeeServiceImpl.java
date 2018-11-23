package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.EmployeeRepository;
import com.cg.entities.Employee;

@Service
@Transactional
public class EmplyeeServiceImpl implements EmployeeService {
     
	@Autowired
	 private EmployeeRepository repository;
	
	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return repository.save(employee);
	}

	@Override
	public List<Employee> loadAll() {
		// TODO Auto-generated method stub
		return repository.loadAll();
	}

}
