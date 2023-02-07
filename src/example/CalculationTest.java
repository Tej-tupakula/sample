package example;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculationTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver Driver= new ChromeDriver();
			Driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
			Driver.manage().window().maximize();
			Driver.findElement(By.xpath("//button[@id=\"wzrk-cancel\"]")).click();
			
			JavascriptExecutor js= (JavascriptExecutor)Driver;
			WebElement cal=Driver.findElement(By.xpath("//*[@id=\"mc_mainWrapper\"]/div[2]/div/div[5]/div/div[1]/p"));
				js.executeScript("arguments[0].scrollIntoView()", cal);
		
		FileInputStream file = new FileInputStream("C://Users//tejku//Documents//Data//Sample.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			
		int rowcount=sheet.getLastRowNum();
		//System.out.println(rowcount);
		for(int i=1;i<rowcount;i++) 
			{
				XSSFRow row= sheet.getRow(i);
				
				//String var=row.getCell(0).getStringCellValue();
				
				XSSFCell principlecell=row.getCell(0);
				int princ=(int)principlecell.getNumericCellValue();
			
				XSSFCell roi=row.getCell(1);
				int rateofinterest=(int)roi.getNumericCellValue();
				
				XSSFCell Period=row.getCell(2);
				int Per=(int)Period.getNumericCellValue();
				
				XSSFCell Frequency=row.getCell(3);
				String Fre=Frequency.getStringCellValue();
				
				XSSFCell Maturity=row.getCell(4);
				int Exp_Maturity=(int)Maturity.getNumericCellValue();
				
				//Passing the elements using send keys
				Driver.findElement(By.xpath("//*[@id=\"principal\"]")).sendKeys(String.valueOf(princ)); // Converting int Type to String, So used String method
				Driver.findElement(By.id("interest")).sendKeys(String.valueOf(rateofinterest));
				Driver.findElement(By.id("tenure")).sendKeys(String.valueOf(Per));
				
				Select periodcom=new Select (Driver.findElement(By.id("tenurePeriod")));
					periodcom.selectByVisibleText("year(s)");
				
				Select Frequency1= new Select (Driver.findElement(By.id("frequency")));	
					Frequency1.selectByVisibleText(Fre);
					
				Driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]")).click();
				
				String Actual= Driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong")).getText();
				
			if(Double.parseDouble(Actual)== Exp_Maturity) 
			{
				System.out.println("Test Successful"+" "+"expected"+" "+Exp_Maturity+" "+"and"+" "+"Actual"+" "+Actual);
			}
			else
			{
				System.out.println("Test Failed"+" "+"expected"+" "+Exp_Maturity+" "+"and"+" "+"Actual"+" "+Actual);
			}
			
			/*	Driver.findElement(By.id("principle")).clear();
				Driver.findElement(By.id("interest")).clear();
				Driver.findElement(By.id("tenure")).clear(); */
				
			Driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img")).click();	
			}
			Driver.close();
	}
}
