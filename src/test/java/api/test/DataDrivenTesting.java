package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Methods;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTesting {
		
	@Test(priority=1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void createUsersDDT(String userID, String userName, String	userFirstName, String userLastName,String email,String password,String	phone) {
		User user=new User();
		user.setId(Integer.parseInt(userID));
		user.setUsername(userName);
		user.setFirstName(userFirstName);
		user.setLastName(userLastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		user.setUserStatus(1);
		Response r=Methods.createUser(user);
		Assert.assertEquals(r.getStatusCode(), 200);
		System.out.println("Codigo al Crear: "+r.getStatusCode());
	}
	@Test(priority=2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void getUsersDDT(String userName) {	
		Response r=Methods.getUser(userName);
		Assert.assertEquals(r.getStatusCode(), 200);
		r.then().log().body();	
	}	
	@Test(priority=3, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void deleteUsersDDT(String userName) {	
		Response r=Methods.deleteUser(userName);
		Assert.assertEquals(r.getStatusCode(), 200);
		System.out.println("Codigo al Eliminar: "+r.getStatusCode());		
	}		
}
