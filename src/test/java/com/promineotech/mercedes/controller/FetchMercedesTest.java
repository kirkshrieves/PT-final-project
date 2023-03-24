package com.promineotech.mercedes.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.promineotech.mercedes.controller.support.FetchMercedesTestSupport;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)//test the random port before continuing 
class FetchMercedesTest extends FetchMercedesTestSupport{

	@Test
	void testThatMercedesNameIsReturnedWhenAValidVinIsEntered() {
		//Given: a valid 4 character VIN
		
		//When: a connection is made to the URI
		
		//Then: a success (OK - 200) status code is returned
		
		//And: the actual list returned is the same as the expected list
	}

}
