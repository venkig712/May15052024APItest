package restAPIGorest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class GetCallAPIGorest {
	
	@Test
	public void getcallAPI() {
		
		
		RestAssured.baseURI= "https://gorest.co.in";
		RestAssured.basePath="/public/v2/users";
		
		given().log().all()
		.contentType(ContentType.JSON)
		.auth()
		.oauth2("f044dec310ab566e156bb8acb2c54d7b0bde89340640166169ad8846215f54cf")
		.when().log().all()
		.get()
		.then().log().all()
		.statusCode(200);
		
	}
	
	

}
