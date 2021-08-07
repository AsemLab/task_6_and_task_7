package jo.secondstep.repositories;

import org.springframework.data.repository.CrudRepository;

import jo.secondstep.tables.Job;

public interface JobsRepository extends CrudRepository<Job, Integer> {

}
