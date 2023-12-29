package day23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Initialization of FluentWait
	    Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver)
	       .withTimeout(Duration.ofSeconds(50))
	       .pollingEvery(Duration.ofSeconds(15))
	       .ignoring(NoSuchElementException.class);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement usernameTextField = myWait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.xpath("//*[@placeholder='Username']"));
		     }
		});
		
		WebElement passwordTextField = myWait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.xpath("//*[@placeholder='Password']"));
		     }
		});
		
		usernameTextField.sendKeys("Admin");
		passwordTextField.sendKeys("admin123");
		Thread.sleep(5000);
		
	
		driver.close();
	}

}
