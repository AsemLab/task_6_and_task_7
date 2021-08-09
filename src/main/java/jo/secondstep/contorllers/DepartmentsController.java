package jo.secondstep.contorllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jo.secondstep.repositories.DepartmentsRepository;
import jo.secondstep.tables.Department;

@Controller
@RequestMapping(path = "/departments")
public class DepartmentsController {
	@Autowired
	private DepartmentsRepository departmentsRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewDepartment(@RequestParam String name, Integer location_id) {
		
		Department department = new Department(name, location_id);
		departmentsRepository.save(department);
		return "Department: "+department.getName()+" has been saved to database";
		
	}

	@GetMapping(path = "/all")
	public @ResponseBody String getAllDepartments() {
		StringBuilder result = new StringBuilder();
		
		for(Department d: departmentsRepository.findAll())
			result.append(d+"<br>");
		return result.toString();
	}
	
	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteDepartment(@PathVariable(value = "id") Integer id) {
		
		Department department = departmentsRepository.findById(id).orElseGet(null);
		departmentsRepository.delete(department);
		
		return "Department: "+department.getName()+" has been deleted from database";
		
	}

	
	
	@GetMapping(path = "/get/{id}")
	public @ResponseBody Iterable<Department> getDepartments(@PathVariable(value = "id") String id) {
		
		return departmentsRepository.getDepartmentByCountry(id);
	}
}