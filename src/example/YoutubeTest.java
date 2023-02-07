package example;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YoutubeTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.youtube.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='search']")).click();
		
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Automation");
		
		WebElement Search = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
			Search.click();
			Thread.sleep(5000);
			
			driver.close();
	}

}
