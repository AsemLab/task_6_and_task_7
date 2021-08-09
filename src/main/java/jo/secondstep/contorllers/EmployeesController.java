package jo.secondstep.contorllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jo.secondstep.repositories.EmployeesRepository;
import jo.secondstep.tables.Employee;

@Controller
@RequestMapping(path = "/employees")
public class EmployeesController {
	@Autowired
	private EmployeesRepository employeesRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewEmployee(String first_name, @RequestParam String last_name,
			@RequestParam String email, String phone, @RequestParam String hire_date, @RequestParam Integer job_id,
			@RequestParam Double salary, Integer manager_id, Integer department_id) {

		Employee employee = new Employee(first_name, last_name, email, phone, Date.valueOf(hire_date), job_id, salary,
				manager_id, department_id);
		employeesRepository.save(employee);
		return "Employee: " + employee.getLastName() + " has been saved to database";

	}

	@GetMapping(path = "/all")
	public @ResponseBody String getAllemployees() {
		StringBuilder result = new StringBuilder();

		for (Employee e : employeesRepository.findAll())
			result.append(e + "<br>");

		return result.toString();
	}
	
	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteEmployee(@PathVariable(value = "id") Integer id) {
		
		Employee employee = employeesRepository.findById(id).orElseGet(null);
		
		if(employee != null) {
			employeesRepository.delete(employee);
			return "Employee: "+employee.getId()+" has been deleted from database";
		}
		
		
		return "Error: There is no employee with the id "+id; 
		
	}
}