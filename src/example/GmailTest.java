package example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);

		WebElement Search =driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
			Search.click();
			Search.sendKeys("www.amazon.com");
			Search.sendKeys(Keys.ENTER);
			
		driver.findElement(By.xpath("//*[@id=\"tads\"]/div/div/div/div/div[1]/a/div[1]/div/span ")).click();
		
		WebElement Register =driver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/div/a"));
			Register.click();
			String Expected_Title="Amazon Registration";
			String Actual_Title=driver.getTitle();
		
	if(Expected_Title.equals(Actual_Title)) {
		
		WebElement First_Name= driver.findElement(By.xpath("//input[@id=\"ap_customer_name\"]"));
			First_Name.sendKeys("Tejkumar");
			First_Name.sendKeys(Keys.TAB);	
			
		WebElement Mobile_Num= driver.findElement(By.xpath("//*[@id=\"ap_phone_number\"]"));	
			Mobile_Num.sendKeys("6303612184");	
			Mobile_Num.sendKeys(Keys.TAB);
			Mobile_Num.sendKeys(Keys.TAB);
			
		WebElement Password= driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));	
			Password.sendKeys("like2begood");
			
		driver.findElement(By.xpath("//input[@id=\"continue\"]")).sendKeys(Keys.ENTER);
			Thread.sleep(40);
		driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div/a/i")).click();
		
		//search Bar
		WebElement Search_bar =driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
			Search_bar.click();
			Search_bar.sendKeys("iphone 14");
			Search_bar.sendKeys(Keys.ENTER);
		
		//Login
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
		WebElement Login=driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
			JavascriptExecutor je=(JavascriptExecutor) driver;
			je.executeScript("arguments[0].value='7207258667'", Login);
			Login.sendKeys(Keys.ENTER);
			
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("likE2bEgood",(Keys.ENTER));
			Thread.sleep(1000);
			driver.close();
			
		}	
	}

}
