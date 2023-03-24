package com.promineotech.mercedes.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Engine {
	private Long enginePK;
	private Float engineId;
	private Float oilCapacity;
	private Float engineSize;
}
