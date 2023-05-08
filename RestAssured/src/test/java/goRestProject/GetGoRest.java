package goRestProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetGoRest {
	
	@Test
	public void getGoRest(){
		RestAssured
				.when().get("https://gorest.co.in/")
				
				.then().assertThat().statusCode(200).log().all();
	}

}
