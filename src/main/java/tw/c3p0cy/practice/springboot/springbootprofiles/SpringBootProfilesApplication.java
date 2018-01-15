package tw.c3p0cy.practice.springboot.springbootprofiles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootProfilesApplication implements CommandLineRunner {

	@Autowired
	private WhoAmI whoAmI;

	@Override
	public void run(String... strings) throws Exception {
		log.info(whoAmI.about());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfilesApplication.class, args);
	}
}
