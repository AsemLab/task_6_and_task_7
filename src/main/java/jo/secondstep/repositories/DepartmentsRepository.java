package jo.secondstep.repositories;

import org.springframework.data.repository.CrudRepository;

import jo.secondstep.tables.Department;

public interface DepartmentsRepository extends CrudRepository<Department, Integer> {

}
