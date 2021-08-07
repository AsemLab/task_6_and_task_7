package jo.secondstep.contorllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jo.secondstep.repositories.LocationsRepository;
import jo.secondstep.tables.Job;
import jo.secondstep.tables.Location;


@Controller
@RequestMapping(path = "/locations")
public class LocationsController {
	@Autowired
	private LocationsRepository locationsRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewLocation(String street_address,String postal_code,
			@RequestParam String city,String state_province, @RequestParam String country_id ) {
		
		Location location = new Location(street_address, postal_code, city, state_province, country_id);
		locationsRepository.save(location);
		return "Location "+location.getCity()+" has been saved to database";
		
	}

	@GetMapping(path = "/all")
	public @ResponseBody String getAllLocations() {
		StringBuilder result = new StringBuilder();
		
		for(Location l: locationsRepository.findAll())
			result.append(l+"<br>");
		return result.toString();
	}
	
	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteLocation(@PathVariable(value = "id") Integer id) {
		
		Location location =locationsRepository.findById(id).orElseGet(null);
		
		if(location != null) {
			locationsRepository.delete(location);
			return "Location: "+location.getId()+" has been deleted from database";
		}
		
		
		return "Error: There is no location with the id "+id; 
		
	}
	
}