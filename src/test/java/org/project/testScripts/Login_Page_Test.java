package org.project.testScripts;

import java.io.IOException;

import org.project.Testbase;
import org.project.pages.Login_Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Page_Test extends Testbase{
	public Login_Page loginpage;

	public Login_Page_Test()  {
		super();
	}
	@BeforeMethod
	public void setUp()  {
		initiliazation();
		loginpage = new Login_Page();
	}
	@Test
	public void login()  {
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		loginpage.login(username,password);
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
