package com.promineotech.mercedes.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class AdditionRequest {
	@NotNull
	@Length(max = 4)
	@Pattern(regexp = "[\\w\\s]*")
		private String vinId;
	@NotNull
		private MercedesName name;
	
	@NotNull
	@Length(max = 7)
	@Pattern(regexp = "[\\w\\s]*")
		private String chassisId;
	
	@NotNull
	@Length(max = 40)
	@Pattern(regexp = "[\\w\\s]*")
		private String vehicleName;
}
