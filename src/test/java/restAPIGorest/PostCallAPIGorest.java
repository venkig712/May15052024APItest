package restAPIGorest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import goRestAPIPojo.UserPayload;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostCallAPIGorest {
	
@DataProvider(name = "userdata")	
 public Object[][] userCreation() {
	 
	return new Object[][] {{"Rajashekar1","rajashekar"+System.currentTimeMillis()+"@email.com","male","Active"},
		{"Rajireddy1","rajireddy"+System.currentTimeMillis() +"@email.com","male","Active"},
		{"Rajeshwari1","raajeswari"+System.currentTimeMillis()+"@email.com","male","Active"}
	};
	 
 }
	
	
 @Epic("GoRest API Post call features")	
 @Story("GoRest API Post call verification")
 @Description("Veriy the post call of GoRest API")	
 @Test(dataProvider = "userdata")	
 public void PostCallGorestAPI(String name,String email,String gender,String status) {
	 
	 RestAssured.baseURI= "https://gorest.co.in";
		RestAssured.basePath="/public/v2/users";
		
		
		
		UserPayload user = new UserPayload(name,email,gender,status);
		
		given().log().all()
		.contentType(ContentType.JSON)
		.body(user)
		.auth()
		.oauth2("f044dec310ab566e156bb8acb2c54d7b0bde89340640166169ad8846215f54cf")
		.when().log().all()
		.post()
		.then().log().all()
		.statusCode(201);
	 
	 
 }	
	

}
