package com.promineotech.mercedes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.mercedes.entity.MercedesName;
import com.promineotech.mercedes.service.MercedesMaintenanceService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author kirks
 * 
 * package used for GET (read) function
 *
 */

@RestController
@Slf4j
public class BasicMercedesMaintenanceController implements MercedesMaintenanceController{
	
	//@AutoWired -- removed to access with browser
	private MercedesMaintenanceService mercedesMaintenanceService;
	
	@Override
	public List<Mercedes> fetchMercedes(MercedesName name, String chassis){
		log.info("name={}, chassis={}", name, chassis );
		return mercedesMaintenanceService.fetchMercedes(name, chassis);
	}


}
