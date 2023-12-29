package day23;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateMethod {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		URL myFirstURL = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		URL mySecondURL = new URL("https://www.facebook.com/");
		
		driver.navigate().to(myFirstURL);
		System.out.println(driver.getCurrentUrl());
		driver.navigate().to(mySecondURL);
		System.out.println(driver.getCurrentUrl());
		

		System.out.println(myFirstURL);
		System.out.println(mySecondURL);
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().refresh();
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
		
	}

}
