package in.projectdevelopment.ems.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.projectdevelopment.ems.dto.EmployeeDTO;
import in.projectdevelopment.ems.entity.Employee;
import in.projectdevelopment.ems.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	 
	//Create employee rest API
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {	
		
		return employeeService.createEmployee(employee);
	}
	
	//get employee by id restAPI
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
			Employee employee =employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
		
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDetails){
		Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		this.employeeService.deleteEmployee(id);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Employee deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
