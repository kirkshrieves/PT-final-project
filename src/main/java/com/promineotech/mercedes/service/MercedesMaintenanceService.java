package com.promineotech.mercedes.service;

import java.util.List;

import com.promineotech.mercedes.controller.Mercedes;
import com.promineotech.mercedes.entity.MercedesName;


public interface MercedesMaintenanceService {
	
	
	List<Mercedes> fetchMercedes(MercedesName name, String chassis);
}
