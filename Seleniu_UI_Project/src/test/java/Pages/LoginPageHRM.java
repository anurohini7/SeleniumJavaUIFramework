package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageHRM {
	
	protected WebDriver driver =null; 
	
	public LoginPageHRM(WebDriver driver) {
		this.driver = driver;
	}
	
	private By Username = By.name("username");
	private By Password = By.xpath("//input[@type=\"password\"]");
	private By LoginButton = By.xpath("//button[@type=\"submit\"]");
	private By ForgotPwd = By.partialLinkText("Forgot your");
	private By LoggedUser= By.className("oxd-userdropdown-name");
	private By LoginError = By.cssSelector("div.orangehrm-login-layout div.orangehrm-login-layout-blob div.orangehrm-login-container div.orangehrm-login-slot-wrapper div.orangehrm-login-slot div.orangehrm-login-form div.orangehrm-login-error div.oxd-alert.oxd-alert--error div.oxd-alert-content.oxd-alert-content--error > p.oxd-text.oxd-text--p.oxd-alert-content-text");
	//private By ResetTitle = By.className("oxd-text oxd-text--h6 orangehrm-forgot-password-title");
	
	public void Login_HRM(String Uname, String pwd) throws InterruptedException {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(Username).sendKeys(Uname);
		driver.findElement(Password).sendKeys(pwd);
		driver.findElement(LoginButton).click();
		Thread.sleep(2000);
		
	}
	
	public void ResetPassword(String name) {
		driver.findElement(ForgotPwd).click();
		driver.findElement(Username).sendKeys(name);
		driver.findElement(LoginButton).click();
		
	}
	
	public String successfuloginValidation() {
		driver.findElement(LoggedUser).isDisplayed();
		String user= driver.findElement(LoggedUser).getText();
		return user;
	}
	
	public String InvalidLoginValidation() {
		driver.findElement(LoginError).isDisplayed();
		String errormsg= driver.findElement(LoginError).getText();
		return errormsg;
	}
}
