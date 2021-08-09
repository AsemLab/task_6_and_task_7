package jo.secondstep.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jo.secondstep.tables.Department;

public interface DepartmentsRepository extends CrudRepository<Department, Integer> {

	
	

	@Query(value = "select * from locations l"
			+ "	join countries c1 on l.country_id = c1.country_id"
			+ " join departments d on l.location_id = d.location_id"
			+ "	where c1.country_id = ?1 "
			+ "	order by l.state_province",nativeQuery = true )
	List<Department> getDepartmentByCountry(String countryId);
	
}
