package com.promineotech.mercedes.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vin {
	private Long vinPK;
	private String vinId;
	private String vinOneThree;
	private int wheelTorque;
}
