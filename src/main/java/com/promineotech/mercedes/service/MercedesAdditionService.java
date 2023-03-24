package com.promineotech.mercedes.service;

import com.promineotech.mercedes.entity.Addition;
import com.promineotech.mercedes.entity.AdditionRequest;

public interface MercedesAdditionService {
	Addition createAddition(AdditionRequest additionRequest);
}
