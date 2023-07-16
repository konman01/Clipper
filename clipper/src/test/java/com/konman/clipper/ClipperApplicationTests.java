package com.konman.clipper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.konman.clipper.utility.ClipperUtility;

@SpringBootTest
class ClipperApplicationTests {
	
	private int count = 0;
	
	@Value("${info.app.name}")
	String appName;
	
	@Value("${info.app.description}")
	String appDescription;
	
	@Value("${info.app.version}")
	String appVersion;
	
	@BeforeEach
	public void beforeEach() {
		count = count + 1;
		ClipperUtility.clipperLogger.info("Testing: "+ appName +",Which is "+appDescription
				+" ,Version: "+appVersion+". Execution of test method " + count);
	}
	
	@Test
	@DisplayName("Basic Test")
	void basicTest() {
		assertEquals('1', '1', "the values should be equal");
	}
	
	@AfterEach
	public void afterEach() {
		ClipperUtility.clipperLogger.info("Testing: "+ appName +",Which is "+appDescription
				+" ,Version: "+appVersion+". Execution of test method completed: " + count);
	}

}
