package DDF_JXL;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class DDT {
	WebDriver driver;
	Workbook wb;
	Sheet sh1;
	int numrow;
	String username;
	String password;
	 
	@BeforeTest
	public void Setup(){
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://localhost/login.do");
	}
	 
	@Test(dataProvider="testdata")
	public void TestFireFox(String uname,String password1) throws InterruptedException{
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys(uname);
	driver.findElement(By.name("pwd")).clear();
	driver.findElement(By.name("pwd")).sendKeys(password1);
	driver.findElement(By.xpath("//div[text()='Login ']")).click();
	Thread.sleep(5000);
	Assert.assertTrue(driver.getTitle().contains("actiTIME - Enter Time-Track"), "User not able to Login - Invalid Credentials");
	System.out.println("Page title verified - User able to login successfully");
	}
	 
	@DataProvider(name="testdata")
	public Object[][] TestDataFeed(){
	try {
	wb=Workbook.getWorkbook(new File("E:\\STS\\ExcelData\\DDF_JxlData.xls")); // load workbook
	sh1= wb.getSheet(0); // load sheet in my case I am referring to first sheet only
	numrow=  sh1.getRows(); // get number of rows so that we can run loop based on this
	}
	catch (Exception e){
	e.printStackTrace();
	}
	
	Object [][] data=new Object[numrow][sh1.getColumns()]; // Create 2 D array and pass row and columns
	for(int i=0;i<numrow;i++){ // This will run a loop and each iteration  it will fetch new row
	data[i][0]=sh1.getCell(0,i).getContents(); // Fetch first row username
	data[i][1]=sh1.getCell(1,i).getContents(); // Fetch first row password
	}
	return data; // Return 2d array object so that test script can use the same
	}
	 
	@AfterTest
	public void QuitTC(){
	driver.quit(); // close browser after execution
	}
}
