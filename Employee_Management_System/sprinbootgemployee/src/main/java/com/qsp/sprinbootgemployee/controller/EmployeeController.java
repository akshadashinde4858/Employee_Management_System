package com.qsp.sprinbootgemployee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.sprinbootgemployee.dao.EmployeeDao;
import com.qsp.sprinbootgemployee.dto.Employee;
import com.qsp.sprinbootgemployee.service.EmployeeService;
import com.qsp.sprinbootgemployee.util.ResponseStructure;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@Valid @RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@GetMapping("/getbyid")
	public ResponseEntity<ResponseStructure<Employee>> findById(@RequestParam int id)
	{
		return service.findById(id);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<List<Employee>>> fetchAllEmployee() {
		return service.fetchAllEmployee();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee( @PathVariable int id) {
		return service.deleteEmployee(id);
	}

	@PutMapping("/updateEmployee")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int id,
			@RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}

	@PatchMapping("/updateEmail/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmail(@PathVariable int id,@Valid @RequestParam String email) {
		return service.updateEmail(id, email);
	}

	@PatchMapping("/updatePhone/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updatePhone(@PathVariable int id,@Valid @RequestParam long phone) {
		return service.updatePhone(id, phone);
	}

	@PatchMapping("/updateName/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateName(@PathVariable int id,@Valid @RequestParam String name) {
		return service.updateName(id, name);
	}

	@PatchMapping("/updateSalary/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateSalary(@PathVariable int id,@Valid @RequestParam double salary) {
		return service.updateSalary(id, salary);
	}

	@GetMapping("/findByEmail")
	public ResponseEntity<ResponseStructure<Employee>> findByEmail(@RequestParam String email) {
		return service.findByEmail(email);
	}

	@GetMapping("/findbyphone")
	public ResponseEntity<ResponseStructure<Employee>> findByPhone(@RequestParam long phone) {
		return service.findByPhone(phone);
	}

	@GetMapping("/findBySalaryGreaterThan")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeBySalaryGreaterThan(@RequestParam double salary) {
		return service.findBySalaryGreaterThan(salary);
	}

	@GetMapping("/findBySalaryLessThan")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeBySalaryLessThan(@RequestParam double salary) {
		return service.findBySalaryLessThan(salary);
	}
}
