package com.promineotech.mercedes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.mercedes.entity.Chassis;

public interface MercedesDeleteController {
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/mercedes")
	public static void deleteMercedes(@PathVariable String id) {
		Chassis.delete(id);
	}
}
