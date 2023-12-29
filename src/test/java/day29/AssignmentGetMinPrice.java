package day29;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentGetMinPrice {
	
	public static void main(String[]args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com");
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		WebElement myTable = driver.findElement(By.xpath("//table[@class='table']/tbody"));
		
		int totalRows = myTable.findElements(By.tagName("tr")).size();
		//int totalColumns = myTable.findElements(By.tagName("td")).size();
		
		// Declare and initialize double ArrayList
        ArrayList<Double> flightPrice = new ArrayList<>();
		
		for(int row=1; row<=totalRows; row+=1 ) {
			String price = driver.findElement(By.xpath("//table[@class='table']//tbody/tr["+row+"]/td[6]")).getText();
			double numberPrice = Double.parseDouble(price.replace("$", ""));
			System.out.println(numberPrice);
			flightPrice.add(numberPrice);
		}
		
		System.out.println("Minimum Price is: " + Collections.min(flightPrice));
		System.out.println("Maximum Price is: " + Collections.max(flightPrice));
		
		driver.close();
		//prices = driver.findElements(By.xpath("//table[@class='table']//tbody/tr[1]/td[6]"))
		
		
		
		
		
	}

}
