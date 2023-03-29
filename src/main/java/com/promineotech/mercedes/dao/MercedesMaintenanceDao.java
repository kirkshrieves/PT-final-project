package com.promineotech.mercedes.dao;

import java.util.List;

import com.promineotech.mercedes.entity.Chassis;

public interface MercedesMaintenanceDao {
	List<Chassis> fetchMercedes(Chassis name);
}
