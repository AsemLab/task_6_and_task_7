package jo.secondstep.repositories;

import org.springframework.data.repository.CrudRepository;

import jo.secondstep.tables.Region;

public interface RegionsRepository extends CrudRepository<Region,Integer> {

}
