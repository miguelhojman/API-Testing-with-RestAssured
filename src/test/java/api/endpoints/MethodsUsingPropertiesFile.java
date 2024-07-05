package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.response.Response;

public class MethodsUsingPropertiesFile {

	public static ResourceBundle getURL() {
		ResourceBundle routes= ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(User payload) {
		Response r = given()
					.header("accept", "application/json")
					.header("Content-Type", "application/json")
					.body(payload)
				.when()
					.post(getURL().getString("post_url"));
		return r;
	}

	public static Response getUser(String username) {
		Response r = given()
					.header("accept", "application/json")
					.pathParam("username", username)
				.when()
					.get(getURL().getString("get_url"));
		return r;
	}
	public static Response updateUser(User payload, String username) {
		Response r = given()
						.header("accept", "application/json")
						.header("Content-Type", "application/json")
						.pathParam("username", username)
						.body(payload)
					.when()
						.put(getURL().getString("update_url"));
		return r;
	}
	public static Response deleteUser(String username) {
		Response r = given()
					.header("accept", "application/json")
					.pathParam("username", username)
				.when()
					.delete(getURL().getString("delete_url"));
		return r;
	}
}
