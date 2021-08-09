package jo.secondstep.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jo.secondstep.tables.Location;

public interface LocationsRepository extends JpaRepository<Location, Integer> {

	@Query(value = "select * from locations l "
			+ "join countries c on l.country_id = c.country_id "
			+ "where c.country_name = ?1",nativeQuery = true)
	List<Location> getByCountry(String countryName);
	
	@Query(value = "select * from locations l "
			+ " join countries c on l.country_id = c.country_id "
			+ " join regions r on r.region_id = c.region_id"
			+ " where r.region_name = ?1",nativeQuery = true)
	List<Location> findByRegion(String regionName);
	
	List<Location> findByCityEndingWith(String endWith);
	
	List<Location> findByPostalCodeNull();
	
	List<Location> findByPostalCodeNotNull();
}
