package com.promineotech.mercedes.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import lombok.Getter;

public class BaseTest {
	@LocalServerPort
	private int serverPort;
	
	@Autowired
	@Getter
	private TestRestTemplate restEmplate;
	
	protected String getBaseUri() {
		return String.format("http://localhost:%d/mercedes", serverPort);
	}
}
