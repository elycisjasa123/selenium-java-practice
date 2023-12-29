package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalCommands {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.manage().window().maximize();
		
		 WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		 System.out.println("Display status of Logo: " + logo.isDisplayed());

		// boolean logoStatus = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		// System.out.println("Display status of logo " + logoStatus);
		
		WebElement searchBoxElement = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println("Input Box is Displayed: " + searchBoxElement.isDisplayed());
		System.out.println("Input Box is Enabled: " + searchBoxElement.isEnabled());
		
		WebElement genderMaleRadio = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement genderFemaleRadio = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		// Before selection
		System.out.println("Radio button male before selected: " + genderMaleRadio.isSelected());
		System.out.println("Radio button female before selected: " + genderFemaleRadio.isSelected());
		
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		
		System.out.println("Radio button male after selected: " + genderMaleRadio.isSelected());
		System.out.println("Radio button male after selected: " + genderFemaleRadio.isSelected());
		
		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		System.out.println("Radio button female after selected: " + genderMaleRadio.isSelected());
		System.out.println("Radio button female after selected: " + genderFemaleRadio.isSelected());
		
	}

}
