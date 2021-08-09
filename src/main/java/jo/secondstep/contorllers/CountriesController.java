package jo.secondstep.contorllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jo.secondstep.repositories.CountriesRepository;
import jo.secondstep.tables.Country;
import jo.secondstep.tables.Region;


@Controller
@RequestMapping(path = "/countries")
public class CountriesController {
	@Autowired
	private CountriesRepository countriesRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewCountry(  @RequestParam String country_id,String name, @RequestParam int region_id ) {
		
		Country country = new Country(country_id,name,new Region());
		countriesRepository.save(country);
		return "Country: "+country.getName()+" has been Saved to database.";
		
	}

	@GetMapping(path = "/all")
	public @ResponseBody String getAllCountries() {
		StringBuilder result = new StringBuilder();
		
		for(Country c: countriesRepository.findAll())
			result.append(c+"<br>");
		return result.toString();
	}
	
	@DeleteMapping(path="/delete/{id}")
	public @ResponseBody String deleteCountry(@PathVariable(value = "id") String id) {
		
		Country country = countriesRepository.findById(id).orElseGet(null);
		
		if(country != null) {
			countriesRepository.delete(country);
			return "Department: "+country.getName()+" has been deleted from database";
		}
		
		
		return "Error: There is no country with the id "+id; 
		
	}
}