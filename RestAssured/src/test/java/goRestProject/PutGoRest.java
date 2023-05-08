package goRestProject;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PutGoRest {
	HashMap<String, String> map = new HashMap<>();

@BeforeMethod
public void creatPayLoad() {
	map.put("name", "Mehdi Modabbir");
	map.put("email", "daniel.modabbir22@gmail.com");
	map.put("gender", "male");
	map.put("status", "active");
	RestAssured.baseURI = "https://gorest.co.in/";
	RestAssured.basePath = "public/v2/users/1460507";
}
@Test
public void UpdateResource() {
	RestAssured
	.given()
	.contentType("application/json")
	.body(map)
	.header("Authorization", "Bearer 27fa7f5af628b096a5a3b0a5bc6739d3bc104c9fce0888adfeaf26144e7a04bc")
	.when()
	.put()
	.then()
	.statusCode(200)
	.log().all();
}
	
}
