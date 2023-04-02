package com.promineotech.mercedes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.mercedes.entity.Addition;
import com.promineotech.mercedes.entity.AdditionRequest;
import com.promineotech.mercedes.service.MercedesMaintenanceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicMercedesUpdateController implements MercedesUpdateController{
	
	
	
//  **Before chat GPT help**
//	@Autowired
//	private MercedesMaintenanceService mercedesMaintenanceService;
//	
//	@Override
//	public Addition updateMercedes(AdditionRequest additionRequest) {
//		log.info("addition={}", additionRequest);
//		return mercedesMaintenanceService.updateMercedes(additionRequest);
//	}

}
