package net.javaLesson.Springboot.Controller;

import java.util.List;
//import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.DeleteMapping;


import net.javaLesson.Springboot.Model.Employee;
import net.javaLesson.Springboot.Repository.EmployeeRepository;
import net.javaLesson.Springboot.Exceptions.ResourceNotfoundException ;

@RestController
@RequestMapping("/api/v1/")
public class EmployeesController {
	
	@Autowired
	
	private EmployeeRepository employeeRepository;
	
	//get employees
	
	@GetMapping("employees")
	public List<Employee> getALLEmployee(){
		return this.employeeRepository.findAll();
	}
	
	//get employee by Id
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long employeeId)
		throws ResourceNotfoundException{
			Employee employee = employeeRepository.findById(employeeId)
					.orElseThrow(() -> new ResourceNotfoundException("Employee not found for this id::"+employeeId));
			
		return ResponseEntity.ok().body(employee);
	}
	
	//save employee
	@PostMapping("employees")
	public Employee createEmployees(@RequestBody Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	//update employee
	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value ="id") Long employeeId,
			@Validated @RequestBody Employee employeeDetails) throws ResourceNotfoundException{
		
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotfoundException("Employee not found for this id::"+employeeId));
		
		employee.setEmail(employeeDetails.getEmail());
		employee.setFirstname(employeeDetails.getFirstname());
		employee.setLastname(employeeDetails.getLastname());
		
		return ResponseEntity.ok(this.employeeRepository.save(employee));
		
		
		/*//delete employee
		@DeleteMapping("employee/{id}")
		public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException{
			Employee employee = employeeRepository.findById(employeeId)
		            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id::" + employeeId));

		    this.employeeRepository.delete(employee);

		    Map<String, Boolean> response = new HashMap<>();
		    response.put("deleted", Boolean.TRUE); 

		    return response;
		}*/
		
		
	}
	
	
	}
