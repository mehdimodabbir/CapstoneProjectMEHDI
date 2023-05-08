package goRestProject;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostGoRest {
	HashMap<String, String> map = new HashMap<>();

	@BeforeMethod
	public void createPayload() {
		map.put("name","Mehdi");
		map.put("email", "daniel.modabbir3322@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI ="https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users";
		
	}
	@Test
	public void CreateResource() {
		RestAssured
		.given()
		.contentType("application/json")
		.body(map)
		.header("Authorization", "Bearer 27fa7f5af628b096a5a3b0a5bc6739d3bc104c9fce0888adfeaf26144e7a04bc")
		.when()
		.post()
		.then()
		.statusCode(201)
		.log().all();
		
	}

}
