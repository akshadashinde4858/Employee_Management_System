package com.qsp.sprinbootgemployee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.sprinbootgemployee.dto.Employee;
import com.qsp.sprinbootgemployee.repo.EmployeeRepo;
import com.qsp.sprinbootgemployee.util.ResponseStructure;




@Repository
public class EmployeeDao 
{
	@Autowired
	private EmployeeRepo repo;
	
	public Employee saveEmployee(Employee employee)
	{
		return repo.save(employee);
	}
	
	public Employee findEmployee(int id)
	{
//		return repo.findById(id).get();
//		To Avoid NOSuchElementException
		Optional<Employee> optional=repo.findById(id);
		if(optional.isPresent())
		{
			Employee employee=optional.get();
			return employee;
		}
		else
		{
			return null;
		}
		
	}
	
	public List<Employee> fetchAllEmployee()
	{
		return repo.findAll();
	}
	
	public Employee deleteEmployee(int id)
	{
		Optional<Employee> optional=repo.findById(id);
		if(optional.isPresent())
		{
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}
	
	public Employee updateEmployee(int id, Employee employee)
	{
		Optional< Employee> optional=repo.findById(id);
		
		if(optional.isPresent())
		{
			employee.setId(id);
			return repo.save(employee);
		}
		return null;			
	}
	
	
	public Employee findByEmail(String email)
	{
		return repo.findEmployeeByEmail(email);
	}
	
	public Employee findByPhone(long phone)
	{
//		return repo.findStudentByPhone(phone);
		return repo.findEmployeeByPhone(phone);
	}
	
	public List<Employee> findEmployeeBySalaryGreaterThan(double salary)
	{
		return repo.findEmployeeBySalaryGreaterThan(salary);
	}
//
	public List<Employee> findEmployeeBySalaryLessThan(double salary)
	{
		return repo.findEmployeeBySalaryLessThan(salary);
	}
} 
