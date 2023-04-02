package com.promineotech.mercedes.controller;

import javax.validation.Valid;

import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.mercedes.entity.Addition;
import com.promineotech.mercedes.entity.AdditionRequest;
import com.promineotech.mercedes.entity.Chassis;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.servers.Server;

//**Removed to try another method for the PUT function**
//@Validated
//@RequestMapping("/mercedes")
//@OpenAPIDefinition(info = @Info(title = "Mercedes Update Service"), servers = {
//		@Server(url = "http://localhost:8080", description = "Local server.")})


public interface MercedesUpdateController {
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	public static void updateMercedes(@RequestBody Chassis chassis, @PathVariable String id) {
		chassis.update(chassis, id);
	}
	
	
//	**Before chat GPT help**
//	@GetMapping
//	@ResponseStatus(code = HttpStatus.OK)
//	Addition updateMercedes(@Valid @RequestBody AdditionRequest additionRequest);
	
}
