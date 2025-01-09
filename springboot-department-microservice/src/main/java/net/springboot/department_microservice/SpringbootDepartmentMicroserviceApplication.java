package net.springboot.department_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringbootDepartmentMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDepartmentMicroserviceApplication.class, args);
	}

}
