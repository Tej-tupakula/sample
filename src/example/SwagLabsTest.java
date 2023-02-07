package example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SwagLabsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
		
		WebDriver Swag = new ChromeDriver(options);
			Swag.get("https://www.saucedemo.com/");
			Swag.manage().window().maximize();
	
		WebElement User_Name= Swag.findElement(By.xpath("//input[@id=\"user-name\"]"));
			User_Name.click();
			User_Name.sendKeys("standard_user");
			User_Name.sendKeys(Keys.TAB);
		
		WebElement Pass_Code= Swag.findElement(By.xpath("//input[@id=\"password\"]"));
			Pass_Code.sendKeys("secret_sauce");
			Pass_Code.sendKeys(Keys.ENTER);	
		
		WebElement Items_sel= Swag.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
			Items_sel.click();
			Swag.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
			
			Swag.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();	
			Swag.findElement(By.xpath("//button[@id=\"checkout\"]")).click();
		
		WebElement First_Name= Swag.findElement(By.xpath("//*[@id=\"first-name\"]"));
			First_Name.click();
			First_Name.sendKeys("standard_user");
			First_Name.sendKeys(Keys.TAB);
			
		WebElement Last_Name= Swag.findElement(By.xpath("//*[@id=\"last-name\"]"));
			Last_Name.sendKeys("Revanth");
			Last_Name.sendKeys(Keys.TAB);
		
		WebElement Pin_code= Swag.findElement(By.xpath("//*[@id=\"postal-code\"]"));
			Pin_code.sendKeys("213421");
			Thread.sleep(5000);	
			Swag.findElement(By.xpath("//*[@id=\"continue\"]")).click();
			Thread.sleep(5000);
			Swag.findElement(By.xpath("//*[@id=\"finish\"]")).click();
			Thread.sleep(5000);
			Swag.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();

	}

}
