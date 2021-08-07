package jo.secondstep.repositories;

import org.springframework.data.repository.CrudRepository;

import jo.secondstep.tables.Dependent;

public interface DependentsRepository extends CrudRepository<Dependent, Integer> {

}
