package dev.tedros.visionplus;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.tedros.visionplus.run.Location;
import dev.tedros.visionplus.run.Run;
import dev.tedros.visionplus.run.JdbcClientRunRepository;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("Application started successfully");
	}

	// @Bean
	// CommandLineRunner runner(RunRepository runRepository) {
	// return args -> {
	// Run run = new Run(1, "First run", LocalDateTime.now(),
	// LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5,
	// Location.INDOOR);
	// runRepository.create(run);
	// log.info("Run: " + run);
	// };
	// }

}
