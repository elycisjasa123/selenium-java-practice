package day40;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {

	WebDriver driver;
	
	//Constructor
	LoginPage2(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Webelements locators + identification
	// @FindBy(xpath="//img[@alt='company-branding']")
	
	@FindBy(how=How.XPATH, using="//img[@alt='company-branding']")
	WebElement img_logo_element;
	
	@FindBy(css="input[placeholder='Username']")
	WebElement username_txtbox_element;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password_txtbox_element;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement login_btn_element;
	
	
	// Action methods
	public void setUserName(String username) {
		username_txtbox_element.sendKeys(username);
	}
	
	public void setPassword(String password) {
		password_txtbox_element.sendKeys(password);
	}
	
	public void clickLogin() {
		login_btn_element.click();
	}
	
	public boolean checkLogoPresence() {
		boolean logoStatus = img_logo_element.isDisplayed();
		return logoStatus;
	}
	
	
}
