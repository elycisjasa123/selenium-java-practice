package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo1 {

	WebDriver driver;
	
	@BeforeClass
	void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider="ld1")
	void login(String email, String password) {
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		String exp_title = "nopCommerce demo store";
		String act_title = driver.getTitle();
		
		Assert.assertEquals(exp_title, act_title);
		
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
	
	
	@DataProvider(name="ld1", indices={0,3})
	String [][] loginData1(){
		String data[][] = {
				{"abc@gmail.com", "test123"},
				{"jasasane1@gmail.com", "jasasane1"},
				{"jasasane2@gmail.com", "jasasane2"},
				{"testuser@gmail.com", "Password@123"},
		};
		
		return data;
	}
	
	@DataProvider(name="ld2")
	String [][] loginData2(){
		String data[][] = {
				{"abc@gmail.com", "test123"},
				{"jasasane1@gmail.com", "jasasane1"},
				{"jasasane2@gmail.com", "jasasane2"},
				{"jasasane3@gmail.com", "jasasane3"},
		};
		
		return data;
	}
}
