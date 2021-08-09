package jo.secondstep.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import jo.secondstep.tables.Region;

public interface RegionsRepository extends JpaRepository<Region,Integer> {

}
