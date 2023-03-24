package com.promineotech.mercedes.controller;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.mercedes.entity.Addition;
import com.promineotech.mercedes.entity.AdditionRequest;
import com.promineotech.mercedes.service.MercedesAdditionService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author kirks
 * 
 * package used for POST (create) function
 *
 */

@RestController
@Slf4j
public class BasicMercedesAdditionController implements MercedesAdditionController{
	
	//@Autowired
	private MercedesAdditionService mercedesAdditionService;
	
	@Override
	public Addition createAddition(AdditionRequest additionRequest) {
		log.debug("Addition={}", additionRequest);
		return mercedesAdditionService.createAddition(additionRequest);
	}
}
