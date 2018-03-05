package MyDDFexcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DDF_ExcelLibrary.ExcelDataConfig;

public class MyDDF {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost/login.do");
	}
	
	@Test (dataProvider="actiTimeData")
	public void loginToActiTime(String username,String password) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("actiTIME - Enter Time-Track"), "Uesr not able to Login - Invalid Credentials");
		System.out.println("Page title verified - User able to login successfully");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="actiTimeData")
	public Object[][] passData(){
		ExcelDataConfig config=new ExcelDataConfig("./ExcelData/DDF_Data.xlsx");
		int rows = config.getRowCount(0);
		Object[][] data=new Object[rows][2];
		for(int i=0; i<rows; i++) {
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
		}
		return data;
	}
}
