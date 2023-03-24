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
}
