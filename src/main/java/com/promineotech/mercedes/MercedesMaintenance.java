package com.promineotech.mercedes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.ComponentsScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentsScanMarker.class})

public class MercedesMaintenance {

	
	public static void main(String[] args) {
		SpringApplication.run(MercedesMaintenance.class, args);

	}

}

/*
* http://localhost:8080/swagger-ui.html
* 
* Create = POST
* Read = GET
* Update = PUT
* Delete = DELETE
*
*/