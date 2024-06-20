package UI_Tests;

import org.checkerframework.checker.lock.qual.NewObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Pages.LoginPageHRM;


public class OrangeHRMLoginTests {
	
	 WebDriver driver;
	
	@BeforeTest
	public void setup() {
		 String ProjPath=System.getProperty("user.dir");
		 System.setProperty("webdriver.chrome.driver", ProjPath+"/Drivers/chromedriver.exe");
		 driver = new ChromeDriver();
	}
	
	@Test
	public void validLoginTest() throws InterruptedException {
		
		LoginPageHRM LogPage = new LoginPageHRM(driver);
		LogPage.Login_HRM("Admin", "admin123");
		String LoggedUser= LogPage.successfuloginValidation();
		Assert.assertEquals(LoggedUser, "manda user", "Found");
		
		
	}
	
	@Test	
	public void InvalidLoginTest() throws InterruptedException {
		
		LoginPageHRM LogPage1 = new LoginPageHRM(driver);
		LogPage1.Login_HRM("Admin", "admin");
		
		String Invaliduser=LogPage1.InvalidLoginValidation();
		Assert.assertEquals(Invaliduser, "Invalid credentials", "Found");
		
		
	}
	
	@AfterTest
	public void Teardown() {
		
		driver.quit();
	}
	
	
	
		
	
	
	
	
	
	

}
