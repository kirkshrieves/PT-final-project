package com.promineotech.mercedes.dao;

import java.util.Optional;

import com.promineotech.mercedes.controller.Mercedes;
import com.promineotech.mercedes.entity.Addition;
import com.promineotech.mercedes.entity.Chassis;
import com.promineotech.mercedes.entity.Engine;
import com.promineotech.mercedes.entity.Vin;

public interface MercedesAdditionDao {
	
	Addition saveAddition(Vin vin, Chassis chassis, Mercedes mercedes);
	
	Optional <Vin> fetchVin(String vinId);
	
	Optional <Chassis> fetchChassis(String chassisId);
	
	Optional <Engine> fetchEngine(String engineId);
}
