package br.ce.lfp.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class ExemploTest {
	
	@Test
	public void primeiroCenario() {
		
		given()
			.log().all()
		.when()
			.get("https://swapi.dev/api/people/1")
		.then()
			.log().all()
			.statusCode(200)
			.body("name", is("Luke Skywalker"))
		;
		
	}
	
	@Test
	public void segundoCenario() {
		
		given()
			.log().all()
		.when()
			.get("https://swapi.dev/api/films/6")
		.then()
			.log().all()
			.statusCode(200)
			.body("director", containsString("Lucas"))
		;
		
	}
	
	@Test
	public void terceiroCenario() {
		
		given()
			.log().all()
		.when()
			.get("https://swapi.dev/api/planets/18")
		.then()
			.log().all()
			.statusCode(200)
			.body("population", not(containsString("99999999")));
		;
		
	}

}
