package edu.cs545.jungleResort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "edu.cs545.jungleresort")
public class JungleResortApplication {

	public static void main(String[] args) {
		SpringApplication.run(JungleResortApplication.class, args);
	}
}
