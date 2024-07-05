package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Methods;
import api.endpoints.MethodsUsingPropertiesFile;
import api.payload.User;
import io.restassured.response.Response;

public class Tests {

	User user;
	Logger logger;
	
	@BeforeClass
	public void createData() {
		Faker f=new Faker();		
		user=new User();
		logger=LogManager.getLogger(this.getClass());
		
		int id=f.number().numberBetween(1, 1000);
		String username=f.name().username();
		String firstName=f.name().firstName();
		String lastName=f.name().lastName();
		String email=f.internet().emailAddress();
		String password=f.internet().password(5,10);
		String phone=f.phoneNumber().cellPhone();
		int userStatus=1;		
		user.setId(id);
		user.setUsername(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		user.setUserStatus(userStatus);
	}	
	@Test(priority=1)
	public void postTest() {	
		logger.info("************* Creating User  *******************");
		Response r=MethodsUsingPropertiesFile.createUser(user);
		Assert.assertEquals(r.getStatusCode(), 200);
		logger.info("************* User Created *******************");
		System.out.println("Codigo al Crear: "+r.getStatusCode());
	}
	@Test(priority=2)
	public void getTest() {		
		logger.info("************* Obtaining User  *******************");
		Response r=MethodsUsingPropertiesFile.getUser(user.getUsername());
		r.then().log().body();		
		Assert.assertEquals(r.getStatusCode(), 200);
		logger.info("*************  User Obtained  *******************");
	}	
	@Test(priority=3)
	public void updateTest() {				
		user.setFirstName("Miguel");
		user.setLastName("Hojman");
		logger.info("************* Updating User  *******************");
		Response r=Methods.updateUser(user, user.getUsername());
		Assert.assertEquals(r.getStatusCode(), 200);
		logger.info("*************  User Updated *******************");
		System.out.println("Codigo al Modificar: "+r.getStatusCode());
	}
	//pongo este test para verificar el update
	@Test(priority=4)
	public void getTest2() {	
		logger.info("************* Obtaining User  *******************");
		Response r=Methods.getUser(user.getUsername());
		r.then().log().body();		
		Assert.assertEquals(r.getStatusCode(), 200);
		logger.info("*************  User Obtained  *******************");
	}
	@Test(priority=5)
	public void deleteTest() {		
		logger.info("************* Deleting  User   *******************");
		Response r=Methods.deleteUser(user.getUsername());
		Assert.assertEquals(r.getStatusCode(), 200);
		System.out.println("Codigo al Borrar: "+r.getStatusCode());
		logger.info("*************  User Deleted  *******************");
	}		
}
