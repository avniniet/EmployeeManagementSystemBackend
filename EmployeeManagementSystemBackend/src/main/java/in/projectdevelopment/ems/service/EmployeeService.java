package in.projectdevelopment.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.projectdevelopment.ems.dto.EmployeeDTO;
import in.projectdevelopment.ems.entity.Employee;
import in.projectdevelopment.ems.exception.ResourceNotFoundException;
import in.projectdevelopment.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
  private final String EMPLOYEE_NOT_PRESENT = "Employee is not present with employee id ";
	
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
			  findById(id).orElseThrow(()-> new ResourceNotFoundException(EMPLOYEE_NOT_PRESENT+id));
  }
  
  public Employee updateEmployee(Long id, EmployeeDTO employeeDetails) {
	  Employee employee = employeeRepository.
	  findById(id).orElseThrow(()-> new ResourceNotFoundException(EMPLOYEE_NOT_PRESENT+id));
	  
	  employee.setFirstName(employeeDetails.getFirstName());
	  employee.setLastName(employeeDetails.getLastName());
	  employee.setEmailId(employeeDetails.getEmailId());
	  
	 
	  return employeeRepository.save(employee);
  }
  
  public void deleteEmployee(Long id) {
	  Employee employee = employeeRepository.
			  findById(id).orElseThrow(()-> new ResourceNotFoundException(EMPLOYEE_NOT_PRESENT+id));
	  employeeRepository.delete(employee);
	  
	  
  }
}
