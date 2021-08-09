package jo.secondstep.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jo.secondstep.tables.Job;

public interface JobsRepository extends CrudRepository<Job, Integer> {

	List<Job> findByMinSalaryGreaterThan(double minSalary);
	
	List<Job> findByTitleStartingWith(String s);
}
