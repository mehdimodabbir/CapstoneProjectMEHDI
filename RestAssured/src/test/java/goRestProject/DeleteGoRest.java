package goRestProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteGoRest {
	@Test
	public void DeleteUser() {
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users/1460507/";
		
		RestAssured
		.when()
		.delete()
		.then()
		.statusCode(204);
	}

}
