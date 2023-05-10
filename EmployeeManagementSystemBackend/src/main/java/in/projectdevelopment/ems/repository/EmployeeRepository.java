/**
 * 
 */
package in.projectdevelopment.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.projectdevelopment.ems.entity.Employee;

/**
 * @author lenovo1
 *
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
