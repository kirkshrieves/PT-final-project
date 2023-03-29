package com.promineotech.mercedes.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.mercedes.controller.Mercedes;
import com.promineotech.mercedes.dao.MercedesAdditionDao;
import com.promineotech.mercedes.entity.Addition;
import com.promineotech.mercedes.entity.AdditionRequest;
import com.promineotech.mercedes.entity.Chassis;
import com.promineotech.mercedes.entity.Vin;

public class DefaultMercedesAdditionService implements MercedesAdditionService {
	
	@Autowired
	private MercedesAdditionDao mercedesAdditionDao;
	
	@Transactional
	@Override
	
	public Addition createAddition(AdditionRequest additionRequest) {
		Vin vin = getVin(additionRequest);
		Chassis chassis = getChassis(additionRequest);
		Chassis mercedes = getChassis(additionRequest);
		
		return mercedesAdditionDao.saveAddition(vin, chassis, mercedes);
	}

	private Chassis getMercedes(AdditionRequest additionRequest) {
		return mercedesAdditionDao.fetchChassis(additionRequest.getChassisId())
				.orElseThrow(() -> new NoSuchElementException("Mercedes with ID="
						+ additionRequest.getChassisId() + " was not found"));
	}

	private Chassis getChassis(AdditionRequest additionRequest) {
		return mercedesAdditionDao.fetchChassis(additionRequest.getChassisId())
				.orElseThrow(() -> new NoSuchElementException("Chassis with ID="
						+ additionRequest.getChassisId() + " was not found"));
	}

	private Vin getVin(AdditionRequest additionRequest) {
		return mercedesAdditionDao.fetchVin(additionRequest.getVinId())
		.orElseThrow(() -> new NoSuchElementException("Vin with ID="
				+ additionRequest.getVinId() + " was not found"));
	}

}
