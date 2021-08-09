package jo.secondstep.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jo.secondstep.tables.Country;

public interface CountriesRepository extends JpaRepository<Country, String> {

	@Query(value = "select * from regions r join countries c on " + "r.region_id = c.region_id"
			+ " where r.region_name = ?1", nativeQuery = true)
	List<Country> getCountriesByRegionName(String regionName);

	@Query(value = "select * from countries" + " where country_name like ?1%", nativeQuery = true)
	List<Country> findByCountryNameStartingWith(String startWith);
}
