package com.arthur.Api_funcionarios;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("repository")
@EntityScan("Models")
@SpringBootApplication(scanBasePackages = {"Controller", "services", "repository", "Models"})
public class ApiFuncionariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFuncionariosApplication.class, args);
	}

}
