package day23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				WebDriverManager.chromedriver().setup();
				
				WebDriver driver = new ChromeDriver();
				
				//initialize explicit wait
				WebDriverWait waitCondition = new WebDriverWait(driver, Duration.ofSeconds(10));
				
				driver.manage().window().maximize();
				
		
				driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				WebElement usernameTextField = waitCondition.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Username']")));
				WebElement passwordTextField = waitCondition.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Password']")));
			
				usernameTextField.sendKeys("Admin");
				passwordTextField.sendKeys("admin123");
				
				driver.close();
	}

}
