package jo.secondstep.repositories;

import org.springframework.data.repository.CrudRepository;

import jo.secondstep.tables.Employee;
public interface EmployeesRepository extends CrudRepository<Employee, Integer> {

}
