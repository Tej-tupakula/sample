package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XyzBank {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver Driver= new ChromeDriver();
		Driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		Driver.manage().window().maximize();
		
		Driver.findElement(By.tagName("/html/body/div/div/div[2]/div/div[1]/div[2]")).click();
			//BankManager.click();
		//BankManager.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]"));	

	}

}
