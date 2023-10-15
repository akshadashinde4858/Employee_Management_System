package com.qsp.sprinbootgemployee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.sprinbootgemployee.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> 
{
	Employee findEmployeeByEmail(String email);
	Employee findEmployeeByPhone(long phone);
//	@Query("SELECT e FROM Employee e where e.phone=?1")
//	Employee employeeByPhone(long phone);

	List<Employee> findEmployeeBySalaryGreaterThan(double salary);
	
	List<Employee> findEmployeeBySalaryLessThan(double salary);
}
