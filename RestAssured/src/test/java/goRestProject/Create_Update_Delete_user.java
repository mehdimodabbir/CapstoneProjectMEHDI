package goRestProject;

import java.util.HashMap;
import java.util.UUID;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Create_Update_Delete_user {
	HashMap<String, String> map = new HashMap<String, String>();
	String id;
	UUID uuid = UUID.randomUUID();

	@BeforeTest
	public void CreatePayLoad() {
		map.put("name", "Daniel");
		map.put("email", uuid + "@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users";

	}

	@Test(priority=0)
	public void CreatUser() {
		Response response = RestAssured.given().contentType("application/json").body(map)
				.header("Authorization", "Bearer 27fa7f5af628b096a5a3b0a5bc6739d3bc104c9fce0888adfeaf26144e7a04bc")
				.when().post().then().statusCode(201).log().all().contentType(ContentType.JSON).extract().response();

		JsonPath jsonPath = response.jsonPath();
		id = jsonPath.get("id").toString();
		System.out.println(id);
	}
	
@Test(priority=1)
public void updateResurce() {
	map.put("name", "Daniel Modabbir");
	map.put("email", uuid + "@gmail.com");
	map.put("gender", "male");
	map.put("status", "active");
	RestAssured.baseURI = "https://gorest.co.in/";
	RestAssured.basePath = "public/v2/users/" + id;
	
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
@Test(priority=2)
public void deleteUser() {
	
	RestAssured.baseURI = "https://gorest.co.in/";
	RestAssured.basePath = "public/v2/users/" + id;
	
	RestAssured
	.given()
	.contentType("application/json")
	.body(map)
	.header("Authorization", "Bearer 27fa7f5af628b096a5a3b0a5bc6739d3bc104c9fce0888adfeaf26144e7a04bc")
	.when()
	.delete()
	.then()
	.statusCode(204)
	;
		
	
}
}

