package jo.secondstep.mainapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("jo.secondstep.repositories")
@EntityScan("jo.secondstep.tables")
@ComponentScan({ "jo.secondstep.contorllers" })
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class);
	}
}
