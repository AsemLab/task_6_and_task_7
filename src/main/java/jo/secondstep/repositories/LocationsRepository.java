package jo.secondstep.repositories;

import org.springframework.data.repository.CrudRepository;

import jo.secondstep.tables.Location;

public interface LocationsRepository extends CrudRepository<Location, Integer> {

}
