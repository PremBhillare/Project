package org.project.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.project.Testbase;

public class Login_Page extends Testbase{
	
	public Login_Page()  {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='userid']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath ="//button[@type='submit']")
	WebElement loginBtn;
	
	public void login(String uname, String pword) {
		username.sendKeys(uname);
		password.sendKeys(pword);
		loginBtn.click();
	}
}

