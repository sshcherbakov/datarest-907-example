package com.example;

import static com.jayway.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Datarest907ExampleApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)
public class Datarest907ExampleApplicationTests {

	@LocalServerPort
    private int port;

	@Before
	public void setUp() {
		RestAssured.baseURI = "http://localhost:"+port;
	}
	
	@Test
	public void testDatarest907() {
		
        given().
		when().
		        get("/myentities").
		then().
		        statusCode(SC_OK).
				body("_embedded.myEntities.myJodaTime", everyItem(is(instanceOf(String.class))));

	}

}
