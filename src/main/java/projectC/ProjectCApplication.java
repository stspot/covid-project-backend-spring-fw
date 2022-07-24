package projectC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProjectCApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectCApplication.class, args);
	}

}
