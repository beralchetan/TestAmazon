package myDemoprojectMaven.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;



import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import myDemoprojectMaven.pom.*;
import utils.Utility;


public class ActitimetestM extends Base{
	
	WebDriver driver;
	ActitimeloginpageM ActitimeloginpageM;
	ActitimehomepageM ActitimehomepageM;
	//Actions act;
	String TestID;
	
	@BeforeTest
	@Parameters("browser")
    public void launchBrowser(String browser)
    {
    	if(browser.equalsIgnoreCase("Chrome"))
    	{
    		 driver = openChromeBrowser();
    	}
    	else
    	{
    		if(browser.equalsIgnoreCase("Firefox"))
    		{
       		 driver = openFirefoxBrowser();
       	    }
    		
    	}
		  driver.manage().window().maximize();
		  
		  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	
	@BeforeClass
	public void beforeClass()
	{
		ActitimeloginpageM = new ActitimeloginpageM(driver);
	   ActitimehomepageM = new ActitimehomepageM(driver);
	   //act = new Actions(driver);
	}
	
	@BeforeMethod
	public void loginpagetoactitime() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		driver.get("http://desktop-5gn5u49/login.do");
		String d = Utility.fetchdatafromexcelsheet(2,0);
		ActitimeloginpageM.username(d);
		d = Utility.fetchdatafromexcelsheet(2,2);
		ActitimeloginpageM.password(d);
		ActitimeloginpageM.login();
	
	}
	
	@Test
	public void Test1() throws InterruptedException
	{
		TestID = "T101";
		ActitimehomepageM.report();
		String url= driver.getCurrentUrl();
		
		Assert.assertEquals(url, "http://desktop-5gn5u49/reports/reports.do","User Test fails due to url not match");
		
		
	}
	
	@Test
	public void Test2() throws InterruptedException
	{
		TestID = "T102";
		ActitimehomepageM.user();
		String url= driver.getCurrentUrl();
		Assert.assertEquals(url, "http://desktop-5gn5u49/administration/userlist.do","User Test fails due to url not match");	
		
		
	} 
	
	@AfterMethod
	public void afterMethod() throws InterruptedException, IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		 File dest = new File("E:\\Software Testing Batch\\Screenshot in selenium\\TestID.jpg"); 
		 FileHandler.copy(source, dest);
		ActitimehomepageM.logout();
	}
	
	@AfterClass
	public void afterClass()
	{
		ActitimeloginpageM = null;
		   ActitimehomepageM = null;
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
	}
		
	


}
