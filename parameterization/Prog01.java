package parameterization;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Prog01 {

	public static void main(String[] args) throws BiffException, IOException {
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://petstore.octoperf.com");
		driver.findElement(By.linkText("Enter the Store")).click();
		driver.findElement(By.linkText("Sign In")).click();
		
		FileInputStream f1 = new FileInputStream("F:\\Login.xls");
		Workbook w = Workbook.getWorkbook(f1);
		Sheet s = w.getSheet(0);
		
		String username = s.getCell(0,0).getContents();
		String password = s.getCell(1,0).getContents();
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("signon")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.close();
	}
}