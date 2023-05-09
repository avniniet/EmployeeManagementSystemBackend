package in.projectdevelopment.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.projectdevelopment.ems.model.Employee;
import in.projectdevelopment.ems.service.EmployeeService;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		System.out.println("Get all employee controller");
		return employeeService.getAllEmployee();
	}
}
