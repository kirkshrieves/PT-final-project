package com.promineotech.mercedes.controller;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.mercedes.Constants;
import com.promineotech.mercedes.entity.MercedesName;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * 
 * @author kirks
 * 
 * package used for GET (read) function
 *
 */

@Validated
@RequestMapping("/mercedes")
@OpenAPIDefinition(info = @Info(title = "Mercedes Maintenance Service"), servers = {
	@Server(url = "http://localhost:8080", description = "Local server.")})


public interface MercedesMaintenanceController {

	

	// @formatter:off
	@Operation(
			summary = "Returns a list of Mercedes",
			description = "Returns a list of Mercedes given an option",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "A list of Mercedes is returned",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Mercedes.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "No Mercedes were found with the input criteria",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occurred.",
							content = @Content(mediaType = "application/json"))
			},
			parameters = {
					@Parameter(
							name = "name",
							allowEmptyValue = false,
							required = false,
							description = "Select the name of the vehicle to recieve the chassis code"
							)
			}
		)
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Mercedes> fetchMercedes(
			@RequestParam(required = false)
			MercedesName name,
			@Length(max = Constants.TRIM_MAX_LENGTH)
			@Pattern(regexp = "[\\w\\s]*")
			@RequestParam(required = false)
			String chassis);

	// @formatter:on
}

//@GetMapping
//@ResponseStatus(code = HttpStatus.OK)
//List<Mercedes> fetchMercedes(
//		@RequestParam(required = false)
//			Mercedes mercedes,
//		@Length(max = Constants.TRIM_MAX_LENGTH)//pom dependency added
//		@Pattern(regexp = "[\\w\\s]*")//pom dependency added
//		@RequestParam(required = false)
//		String chassis);
