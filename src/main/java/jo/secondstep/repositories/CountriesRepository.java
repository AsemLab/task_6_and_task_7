package jo.secondstep.repositories;

import org.springframework.data.repository.CrudRepository;

import jo.secondstep.tables.Country;

public interface CountriesRepository extends CrudRepository<Country, String> {

}
