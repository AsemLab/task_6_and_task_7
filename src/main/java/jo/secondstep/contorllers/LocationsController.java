package jo.secondstep.contorllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jo.secondstep.repositories.CountriesRepository;
import jo.secondstep.repositories.LocationsRepository;
import jo.secondstep.repositories.RegionsRepository;
import jo.secondstep.tables.Country;
import jo.secondstep.tables.Location;
import jo.secondstep.tables.Region;

@Controller
@RequestMapping(path = "/locations")
public class LocationsController {

	public static final String LOCATION_PATH = "/location";
	public static final String REGION_PATH = "/region";
	public static final String COUNTRY_PATH = "/country";

	@Autowired
	private LocationsRepository locationsRepository;
	@Autowired
	private RegionsRepository regionsRepository;
	@Autowired
	private CountriesRepository countriesRepository;

	/*
	 * 
	 * 
	 * 
	 * Code for Locations table
	 * 
	 * 
	 * 
	 * 
	 */

	@PostMapping(path = LOCATION_PATH)
	public @ResponseBody String addNewLocation(String street_address, String postal_code, @RequestParam String city,
			String state_province, @RequestParam String country_id) {

		Country country = countriesRepository.getById(country_id);

		Location location = new Location(street_address, postal_code, city, state_province, country);
		locationsRepository.save(location);
		return "Location " + location.getCity() + " has been saved to database";

	}

	@GetMapping(path = LOCATION_PATH + "/all")
	public @ResponseBody List<Location> getAllLocations() {

		return locationsRepository.findAll();
	}

	@GetMapping(path = LOCATION_PATH + "/{id}")
	public @ResponseBody Location getLocationById(@PathVariable(value = "id") Integer id) {
		return locationsRepository.findById(id).get();
	}

	@DeleteMapping(path = LOCATION_PATH + "/{id}")
	public @ResponseBody String deleteLocation(@PathVariable(value = "id") Integer id) {

		Location location = locationsRepository.findById(id).orElseGet(null);

		if (location != null) {
			locationsRepository.delete(location);
			return "Location: " + location.getCity() + " has been deleted from database";
		}

		return "Error: There is no location with the id " + id;

	}

	@PutMapping(path = LOCATION_PATH + "/{id}")
	public @ResponseBody Location updateLocationById(@PathVariable(value = "id") Integer id, String street_address,
			String postal_code, String city, String state_province, String country_id) {

		Location location = locationsRepository.findById(id).get();

		if (street_address != null)
			location.setStreetAddress(street_address);
		if (postal_code != null)
			location.setPostalCode(postal_code);
		if (city != null)
			location.setCity(city);
		if (state_province != null)
			location.setStateProvince(state_province);
		if (country_id != null) {

			Country country = countriesRepository.findById(country_id).get();
			location.setCountry(country);
		}

		locationsRepository.save(location);
		return location;
	}
	
	@GetMapping(path = LOCATION_PATH + "/country/{name}")
	public @ResponseBody List<Location> getLocationByCountry(@PathVariable(value = "name") String countryName) {
		return locationsRepository.getByCountry(countryName);
	}
	
	@GetMapping(path = LOCATION_PATH + "/region/{name}")
	public @ResponseBody List<Location> getLocationByRegion(@PathVariable(value = "name") String regionName) {
		return locationsRepository.findByRegion(regionName);
	}
	
	@GetMapping(path = LOCATION_PATH + "/city/{name}")
	public @ResponseBody List<Location> getLocationByCity(@PathVariable(value = "name") String endWith) {
		return locationsRepository.findByCityEndingWith(endWith);
	}
	
	@GetMapping(path = LOCATION_PATH + "/postal")
	public @ResponseBody List<Location> getLocationHavePostal() {
		return locationsRepository.findByPostalCodeNotNull();
	}
	
	@GetMapping(path = LOCATION_PATH + "/nopostal")
	public @ResponseBody List<Location> getLocationHaveNoPostal() {
		return locationsRepository.findByPostalCodeNull();
	}
	

	/*
	 * 
	 * 
	 * 
	 * Code for Regions table
	 * 
	 * 
	 * 
	 * 
	 */

	@PostMapping(path = REGION_PATH)
	public @ResponseBody String addNewRegion(String name) {

		Region r = new Region(name);
		regionsRepository.save(r);
		return "Region: " + r.getName() + " has been saved to database";

	}

	@GetMapping(path = REGION_PATH + "/all")
	public @ResponseBody Iterable<Region> getAllRegions() {

		return regionsRepository.findAll();
	}

	@GetMapping(path = REGION_PATH + "/{id}")
	public @ResponseBody Region getRegionById(@PathVariable(value = "id") Integer id) {
		return regionsRepository.findById(id).get();
	}

	@DeleteMapping(path = REGION_PATH + "/{id}")
	public @ResponseBody String deleteRegion(@PathVariable(value = "id") Integer id) {

		Region region = regionsRepository.findById(id).orElseGet(null);

		if (region != null) {
			regionsRepository.delete(region);
			return "Region: " + region.getName() + " has been deleted from database";
		}

		return "Error: There is no region with the id " + id;

	}

	@PutMapping(path = REGION_PATH + "/{id}")
	public @ResponseBody Region updateRegionById(@PathVariable(value = "id") Integer id, String name) {

		Region region = regionsRepository.findById(id).get();
		if (region != null && name != null) {
			region.setName(name);
		}

		regionsRepository.save(region);
		return region;
	}
	

	/*
	 * 
	 * 
	 * 
	 * Code for Countries table
	 * 
	 * 
	 * 
	 * 
	 */

	@PostMapping(path = COUNTRY_PATH)
	public @ResponseBody String addNewCountry(@RequestParam String country_id, String name,
			@RequestParam int region_id) {

		Region region = regionsRepository.getById(region_id);

		Country country = new Country(country_id, name, region);
		countriesRepository.save(country);
		return "Country: " + country.getName() + " has been Saved to database.";

	}

	@GetMapping(path = COUNTRY_PATH + "/all")
	public @ResponseBody Iterable<Country> getAllCountries() {

		return countriesRepository.findAll();
	}

	@GetMapping(path = COUNTRY_PATH + "/{id}")
	public @ResponseBody Country getCountryById(@PathVariable(value = "id") String id) {
		return countriesRepository.findById(id).get();
	}

	@DeleteMapping(path = COUNTRY_PATH + "/{id}")
	public @ResponseBody String deleteCountry(@PathVariable(value = "id") String id) {

		Country country = countriesRepository.findById(id).orElseGet(null);

		if (country != null) {
			countriesRepository.delete(country);
			return "Country: " + country.getName() + " has been deleted from database";
		}

		return "Error: There is no country with the id " + id;

	}

	@PutMapping(path = COUNTRY_PATH + "/{id}")
	public @ResponseBody Country updateCountryById(@PathVariable(value = "id") String id, String name,
			Integer region_id) {

		Country country = countriesRepository.findById(id).get();
		if (name != null) {
			country.setName(name);
		}
		if (region_id != null) {
			Region region = regionsRepository.findById(region_id).get();
			country.setRegion(region);
		}

		countriesRepository.save(country);
		return country;
	}

	
	
	@GetMapping(path = COUNTRY_PATH + "/in/{name}")
	public @ResponseBody Iterable<Country> getCountryByRegionName(@PathVariable(value ="name") String name) {
		
		return countriesRepository.getCountriesByRegionName(name);
	}
	
	@GetMapping(path = COUNTRY_PATH + "/start/{start}")
	public @ResponseBody Iterable<Country> getCountryStartWith(@PathVariable(value ="start") String startWith) {
		
		return countriesRepository.findByCountryNameStartingWith(startWith);
	}

	
}