package com.promineotech.mercedes.controller;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Mercedes implements Comparable<Mercedes> {
	
	private Long chassisPK;
	private String vinId;
	private String chassisId;
	private String vehicleName;
	
	@JsonIgnore
	public Long getChassisPK() {
		return chassisPK;
	}
	
	@Override
	public int compareTo(Mercedes that) {
		// @formatter:off
		return Comparator
				.comparing(Mercedes::getChassisId)
				.thenComparing(Mercedes::getVinId)
				.thenComparing(Mercedes::getChassisId)
				.thenComparing(Mercedes::getVehicleName)
				.compare(this,that);
		// @formatter:on
	}

	
}
