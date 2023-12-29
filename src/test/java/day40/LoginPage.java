package day40;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	//Constructor
	LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	// Locators
	By logo_img_loc = By.xpath("//img[@alt='company-branding']");
	By username_txtbox_loc = By.xpath("//input[@placeholder='Username']");
	By password_txtbox_loc = By.xpath("//input[@placeholder='Password']");
	By login_btn_loc = By.xpath("//button[normalize-space()='Login']");
	
	
	
	// Action methods
	public void setUserName(String username) {
		driver.findElement(username_txtbox_loc).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(password_txtbox_loc).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(login_btn_loc).click();
	}
	
	public boolean checkLogoPresence() {
		boolean logoStatus = driver.findElement(logo_img_loc).isDisplayed();
		return logoStatus;
	}
	
	
}
