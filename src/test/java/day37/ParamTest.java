package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParamTest {
	
	WebDriver driver;

	@BeforeClass
	@Parameters({"browser", "url"})
	void setup(String browserDriver, String browserUrl) throws InterruptedException {
		
		if(browserDriver.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserDriver.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserDriver.equals("edge")) {
			try {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}catch(Exception b) {
				System.out.println("Edge Browser is not supported...");
			}
			
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(20000);
		driver.get(browserUrl);
	}
	
	@Test(priority=1)
	void testLogo() {
		
		try {
	    Thread.sleep(3000);
		boolean companyLogoDisplay = driver.findElement(By.cssSelector("img[alt='company-branding']")).isDisplayed();
		Assert.assertEquals(companyLogoDisplay, true);
		}catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test(priority=2)
	void testHomePageTitle() {
		
		driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Title are not match");
		
	}
	
	@AfterClass
	void closeApp() {
		driver.close();
	}
}
