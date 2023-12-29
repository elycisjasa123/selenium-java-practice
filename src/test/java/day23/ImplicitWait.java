package day23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				WebDriverManager.chromedriver().setup();
				
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("Admin");
				driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("admin123");
				driver.close();
	}

}
