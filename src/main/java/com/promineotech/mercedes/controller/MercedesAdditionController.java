package com.promineotech.mercedes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.mercedes.entity.Addition;
import com.promineotech.mercedes.entity.AdditionRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * 
 * @author kirks
 * 
 * package used for POST (create) function
 */

public interface MercedesAdditionController {
	@Operation(
			summary = "Add a Mercedes to the database",
			description = "Returns the created Mercedes",
			responses = {
					@ApiResponse(
							responseCode = "201",
							description = "A created Mercedes is returned",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Addition.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "A Mercedes component was not found with the input criteria",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occurred.",
							content = @Content(mediaType = "application/json"))
			},
			parameters = {
					@Parameter(
							name = "AdditionRequest",
							required = true,
							description = "The order as JSON"),
			}
		)
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Addition createAddition(AdditionRequest additionRequest);

}
