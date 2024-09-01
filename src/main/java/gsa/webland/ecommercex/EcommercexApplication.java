package gsa.webland.ecommercex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import gsa.webland.ecommercex.service.DataseederService;

@SpringBootApplication
public class EcommercexApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercexApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(DataseederService dataseederService){
		return ((args)->
		{
			dataseederService.createUser();
			dataseederService.createProduct();

		}
		);

			
		
	}

}
