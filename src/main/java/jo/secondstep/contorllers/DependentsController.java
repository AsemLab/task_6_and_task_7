package jo.secondstep.contorllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jo.secondstep.repositories.DependentsRepository;
import jo.secondstep.tables.Country;
import jo.secondstep.tables.Dependent;

@Controller
@RequestMapping(path = "/dependents")
public class DependentsController {
	@Autowired
	private DependentsRepository dependentsRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewDependent(@RequestParam String first_name,@RequestParam String last_name,
			@RequestParam String relationship, @RequestParam int employee_id) {
		
		Dependent dependent = new Dependent(first_name, last_name, relationship, employee_id);
		dependentsRepository.save(dependent);
		return "Dependent: "+dependent.getFirstName()+" "+dependent.getLastName()
				+" has been saved to database";
		
	}

	@GetMapping(path = "/all")
	public @ResponseBody String getAllDependents() {
		StringBuilder result = new StringBuilder();
		
		for(Dependent d: dependentsRepository.findAll())
			result.append(d+"<br>");
		return result.toString();
	}
	

	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteDependent(@PathVariable(value = "id") Integer id) {
		
		Dependent dependent = dependentsRepository.findById(id).orElseGet(null);
		
		if(dependent != null) {
			dependentsRepository.delete(dependent);
			return "dependent: "+dependent.getId()+" has been deleted from database";
		}
		
		
		return "Error: There is no dependent with the id "+id; 
		
	}
}