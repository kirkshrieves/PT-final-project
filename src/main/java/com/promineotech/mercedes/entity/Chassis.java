package com.promineotech.mercedes.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Chassis {
	private Long chassisPK;
	private String vinId;
	private String chassisId;
	private String vehicleName;
	public void update(Chassis chassis, String id) {
		// TODO Auto-generated method stub
		
	}
	public static void delete(String id) {
		// TODO Auto-generated method stub
		
	}
}
