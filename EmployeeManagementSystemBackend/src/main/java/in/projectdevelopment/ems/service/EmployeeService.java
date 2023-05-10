package in.projectdevelopment.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import in.projectdevelopment.ems.exception.ResourceNotFoundException;
import in.projectdevelopment.ems.model.Employee;
import in.projectdevelopment.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
  @Autowired
  private EmployeeRepository employeeRepository;
  
  public List<Employee> getAllEmployee(){
	  
	  return employeeRepository.findAll();
  }
  
  public Employee createEmployee(Employee employee) {
	  return employeeRepository.save(employee);
  }

  public Employee getEmployeeById(Long id) {
	  return employeeRepository.
			  findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee is not present with employee id "+id));
  }
  
  public Employee updateEmployee(Long id, Employee employeeDetails) {
	  Employee employee = employeeRepository.
	  findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee is not present with employee id "+id));
	  
	  employee.setFirstName(employeeDetails.getFirstName());
	  employee.setLastName(employeeDetails.getLastName());
	  employee.setEmailId(employeeDetails.getEmailId());
	  
	  Employee updatedEmployee = employeeRepository.save(employee);
	  return updatedEmployee;
  }
  
  public void deleteEmployee(Long id) {
	  Employee employee = employeeRepository.
			  findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee is not present with employee id "+id));
	  employeeRepository.delete(employee);
	  
	  
  }
}
