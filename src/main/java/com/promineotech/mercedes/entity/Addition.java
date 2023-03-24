package com.promineotech.mercedes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author kirks
 * this package will add an additional name to the 'chassis' table
 */
@Data
@Builder
public class Addition {
	private Long chassisPK;
	private Vin vinId;
	private Chassis chassisId;
	private Chassis vehicleName;
	
	@JsonIgnore
	public Long getAdditionPK() {
		return chassisPK;
	}
}
