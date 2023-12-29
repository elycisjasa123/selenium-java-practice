package day17;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class YourTestClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		driver.get("https://admin.shopify.com/store/cult-cellar-test-shop/products?selectedView=all&tag=hkonlinewineshop");

		// Login account
		Thread.sleep(5000);
		driver.findElement(By.id("account_email")).sendKeys("cultcellar@gmail.com");
		
		driver.findElement(By.xpath("//button[@name='commit']")).click(); // Continue with email button
		Thread.sleep(5000);
		driver.findElement(By.id("account_password")).sendKeys("C:GX(Lsm9V9&#2h"); 
		
		driver.findElement(By.xpath("//button[@name='commit']")).click();  // Login button
		
		// It will redirect to lists of products
		
		ArrayList<String> productLink = new ArrayList<>();
		
		List <WebElement> productList = driver.findElements(By.xpath("//a[@class='h7u74']"));
		System.out.println("Total List numbers: " + productList.size());
		
		for(WebElement productName : productList) {
			String selectedProductLink = productName.getAttribute("href");
			productLink.add(selectedProductLink);
		}
		
		String currentVivinoSrc = "";
		String vivinoDescription = "";
		String shopifyDescription = "";
		Set<String> allWindows = new HashSet<>();
		List<String> windowidsList = new ArrayList<>();
		String shopifyTab = "";
		String vivinoTab = "";
		
		for(String link: productLink) {
			System.out.println("Current Link was ----------------------------> " + link);
			driver.get(link);
			WebElement vivino_src=driver.findElement(By.xpath("//button[@id='metafields.wine.vivino_url']//div[contains(@class,'llRQz')]"));
			if(vivino_src.getText().length() > 0) {
				Thread.sleep(3000);
				currentVivinoSrc = vivino_src.getText();
				driver.switchTo().frame(0);
				shopifyDescription = driver.findElement(By.xpath("//body[@data-id='product-description']")).getText();	
				
				
				//System.out.println("Shopify Description: " + shopifyDescription);
				driver.switchTo().defaultContent();
				
				driver.switchTo().newWindow(WindowType.TAB);
				allWindows = driver.getWindowHandles();
				
				// Convert from Set to List
				windowidsList=new ArrayList(allWindows);
				shopifyTab = windowidsList.get(0);
				vivinoTab = windowidsList.get(1);
				
				driver.get(currentVivinoSrc);
				Thread.sleep(3000);
				//System.out.println("After visit of vivino wines: " + driver.getTitle());
				// WebElement description_exists = driver.findElement(By.xpath("//h3[text() = 'Wine description']")); // wine description exists
				
				try {
					WebElement vivinoDescriptionElem = driver.findElement(By.xpath("//tr[@data-testid][7]/td/span/span"));
					// js.executeScript("arguments[0].scrollIntoView();", vivinoDescriptionElem);
					
					js.executeScript("window.scrollBy(0,2000)");
					vivinoDescription = vivinoDescriptionElem.getText();
					//System.out.println("Vivino Description: " + shopifyDescription);
					if(vivinoDescription == shopifyDescription) {
						//System.out.println(shopifyDescription + "is the same on vivino");
					}else {
						//System.out.println(shopifyDescription + "is not the same on vivino");
					}	
				}catch (org.openqa.selenium.NoSuchElementException e) {
					System.out.println("Vivino Wine Description is not available");
				}
				
				
				driver.close();
				driver.switchTo().window(shopifyTab);
				//System.out.println("After switch back to shopify Tab: " + driver.getTitle());
				
			}else {
				// System.out.println("Not Scraped from Vivino");
				currentVivinoSrc="";
				vivinoDescription="";
			}
			
			windowidsList.clear();
			allWindows.clear();
		}
		
		// Switch to new windows
		//driver.switchTo().newWindow(WindowType.TAB);
		//driver.get("h")
		
		
	}

}
