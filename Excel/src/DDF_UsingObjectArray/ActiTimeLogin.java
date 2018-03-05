package DDF_UsingObjectArray;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ActiTimeLogin {
	WebDriver driver;
	@Test (dataProvider="actiTimeData")
	public void loginToActiTime(String username,String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost/login.do");
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("actiTIME - Enter Time-Track"), "Uesr not able to Login - Invalid Credentials");
		System.out.println("Page title verified - User able to login successfully");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="actiTimeData")
	public Object[][] passData(){
		Object[][] data=new Object[3][2];
		data[0][0]="admin1";
		data[0][1]="password";
		
		data[1][0]="admin2";
		data[1][1]="password2";
				
		data[2][0]="admin";  //valid
		data[2][1]="manager";//valid
		return data;
	}
}
