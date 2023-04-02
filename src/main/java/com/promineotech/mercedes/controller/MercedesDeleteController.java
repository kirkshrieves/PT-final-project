package com.promineotech.mercedes.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.promineotech.mercedes.entity.Chassis;

public interface MercedesDeleteController {
	@DeleteMapping
	public static void deleteMercedes(@PathVariable String id) {
		Chassis.delete(id);
	}
}
