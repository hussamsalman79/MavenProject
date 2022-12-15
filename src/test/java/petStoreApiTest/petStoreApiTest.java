package petStoreApiTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class petStoreApiTest {
	@Test(dependsOnMethods = "postApet")
	public void getPetById() {
		RestAssured.given().accept(ContentType.JSON).when().get("https://petstore.swagger.io/v2/pet/1982").then()
				.statusCode(200).contentType(ContentType.JSON);
	}

	@Test
	public void findByStatus() {
		// RestAssured request syntax
		RestAssured.given().accept(ContentType.JSON).contentType("application/json").param("status", "pending").when()
				.get("https://petstore.swagger.io/v2/pet/findByStatus").then().statusCode(200)
				.contentType("application/json");
	}

	@Test (dependsOnMethods = "postAcat")

	public void getById() {
		// Response syntax
		// Create response object which has all the header and body contents
		Response myResponse = RestAssured.given().accept(ContentType.JSON)
		.when().get("https://petstore.swagger.io/v2/pet/1982");

		// print the body
		myResponse.prettyPrint();

		// validate the response and verifying the status code
		myResponse.then().assertThat().statusCode(200);

		String petName = myResponse.path("name");
		System.out.println("Pet name is: " + petName);
		Assert.assertEquals(petName, "Fullah");

		int petId = myResponse.path("id");
		System.out.println("Pet Id is: " + petId);
		Assert.assertEquals(petId, 1982);

		// Access the name and tags from the second object

		int tags0 = myResponse.path("tags[0].id");
		System.out.println("tag 0 id is: " + tags0);
		Assert.assertEquals(tags0, 2022);

		String name0 = myResponse.path("tags[0].name");
		System.out.println("tag 0 pet name is: " + name0);
		Assert.assertEquals(name0, "Persian");

		int tags1 = myResponse.path("tags[1].id");
		System.out.println("tag 1 id is: " + tags1);
		Assert.assertEquals(tags1, 2023);

		String name1 = myResponse.path("tags[1].name");
		System.out.println("tag 1 pet name  is: " + name1);
		Assert.assertEquals(name1, "Semsem");

		String CategoryName = myResponse.jsonPath().getString("category.name");
		System.out.println("Pet Category name is: " + CategoryName);
		Assert.assertEquals(CategoryName, "cat");
	}
	
	
	@Test
	public void postAcat() {
		String  CatrequestBody ="{\n"
				+ "    \"id\": 56756745,\n"
				+ "    \"category\": {\n"
				+ "      \"id\": 21,\n"
				+ "      \"name\": \"cat\"\n"
				+ "    },\n"
				+ "    \"name\": \"Ember\",\n"
				+ "    \"photoUrls\": [\n"
				+ "      \"string\"\n"
				+ "    ],\n"
				+ "    \"tags\": [\n"
				+ "      {\n"
				+ "        \"id\": 18,\n"
				+ "        \"name\": \"persian\"\n"
				+ "      },\n"
				+ "      {\n"
				+ "        \"id\": 2,\n"
				+ "        \"name\": \"Anatolian\"\n"
				+ "      }\n"
				+ "    ],\n"
				+ "    \"status\": \"available\"\n"
				+ "  }"; 
		
		Response myResponse = RestAssured 
				.given().accept(ContentType.JSON).contentType("application/json").body(CatrequestBody)
				.when().post("https://petstore.swagger.io/v2/pet"); 
				
				myResponse.then().statusCode(200)
				.and().contentType("application/json"); 
				
				myResponse.prettyPrint(); 
		
	}
	
	@Test
	public void postApet() {
		String requestBoday = "{\n"
				+ "    \"id\": 198282,\n"
				+ "    \"category\": {\n"
				+ "        \"id\": 39,\n"
				+ "        \"name\": \"dog\"\n"
				+ "    },\n"
				+ "    \"name\": \"Jessy\",\n"
				+ "    \"photoUrls\": [\n"
				+ "        \"string\"\n"
				+ "    ],\n"
				+ "    \"tags\": [\n"
				+ "        {\n"
				+ "            \"id\": 202222,\n"
				+ "            \"name\": \"Blacky\"\n"
				+ "        },\n"
				+ "        {\n"
				+ "            \"id\": 202323,\n"
				+ "            \"name\": \"Tobby\"\n"
				+ "        }\n"
				+ "    ],\n"
				+ "    \"status\": \"available\"\n"
				+ "}"; 
		
		Response myResponse = RestAssured 
		.given().accept(ContentType.JSON).contentType("application/json").body(requestBoday)
		.when().post("https://petstore.swagger.io/v2/pet"); 
		
		myResponse.then().statusCode(200)
		.and().contentType("application/json"); 
		
		myResponse.prettyPrint(); 
		
	}
	
	

}
