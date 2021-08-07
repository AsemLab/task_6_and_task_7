package jo.secondstep.contorllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jo.secondstep.repositories.RegionsRepository;
import jo.secondstep.tables.Job;
import jo.secondstep.tables.Region;

@Controller
@RequestMapping(path = "/regions")
public class RegionsController {
	@Autowired
	private RegionsRepository regionsRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewRegion(String name) {
		
		Region r = new Region(name);
		regionsRepository.save(r);
		return "Region: "+r.getName()+" has been saved to database";
		
	}

	@GetMapping(path = "/all")
	public @ResponseBody String getAllRegions() {
		StringBuilder result = new StringBuilder();
		
		for(Region r: regionsRepository.findAll())
			result.append(r+"<br>");
		return result.toString();
	}
	
	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteRegion(@PathVariable(value = "id") Integer id) {
		
		Region region = regionsRepository.findById(id).orElseGet(null);
		
		if(region != null) {
			regionsRepository.delete(region);
			return "Job: "+region.getId()+" has been deleted from database";
		}
		
		
		return "Error: There is no region with the id "+id; 
		
	}
}