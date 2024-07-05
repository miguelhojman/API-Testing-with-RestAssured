package api.endpoints;

import static io.restassured.RestAssured.*;
import api.payload.User;
import io.restassured.response.Response;

public class Methods {

	public static Response createUser(User payload) {
		Response r = given()
					.header("accept", "application/json")
					.header("Content-Type", "application/json")
					.body(payload)
				.when()
					.post(Routes.post_url);
		return r;
	}

	public static Response getUser(String username) {
		Response r = given()
					.header("accept", "application/json")
					.pathParam("username", username)
				.when()
					.get(Routes.get_url);
		return r;
	}
	public static Response updateUser(User payload, String username) {
		Response r = given()
						.header("accept", "application/json")
						.header("Content-Type", "application/json")
						.pathParam("username", username)
						.body(payload)
					.when()
						.put(Routes.update_url);
		return r;
	}
	public static Response deleteUser(String username) {
		Response r = given()
					.header("accept", "application/json")
					.pathParam("username", username)
				.when()
					.delete(Routes.delete_url);
		return r;
	}
}
