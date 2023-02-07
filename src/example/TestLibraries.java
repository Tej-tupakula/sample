package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLibraries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		//FInd User Name
		WebElement user_name=
		driver.findElement(By.xpath("//input[@id='email']"));
		user_name.sendKeys("tejthupakula@gmail.com");
		
		//For Password
		WebElement pass_word=driver.findElement(By.xpath("//input[@id='pass']"));
		pass_word.sendKeys("likE2bEgood");
		driver.findElement(By.name("login")).click();
	 

	}

}
