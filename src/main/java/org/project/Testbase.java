package org.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import utils.TestUtil;
import utils.WebEventListener;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static FileInputStream file;
		public Testbase()  {
			prop = new Properties();
			
			
			try {
				file = new FileInputStream("src/main/java/config/config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				prop.load(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		public static void initiliazation() 
		{
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome")) 
			{
			System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
			ChromeOptions opt= new ChromeOptions();
			opt.addArguments("--disable-notifications");
			driver = new ChromeDriver(opt);
			}
			else if (browserName.equals("edge")) 
			{
				System.setProperty("webdrvier.chrome.driver","Drivers/egdedriver.exe");
				driver = new EdgeDriver();
			}
			
			e_driver = new EventFiringWebDriver(driver);
			//Now create object of EventListnerHandler to register it with EventFiringWebDriver
			try {
				eventListener = new WebEventListener();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			e_driver.register(eventListener);
			driver= e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("URL"));
			
		}
		
}
