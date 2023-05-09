package in.projectdevelopment.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.projectdevelopment.ems.model.Employee;
import in.projectdevelopment.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
  @Autowired
  private EmployeeRepository employeeRepository;
  
  public List<Employee> getAllEmployee(){
	  
	  return employeeRepository.findAll();
  }

}
