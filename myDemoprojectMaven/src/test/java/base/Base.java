package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Software Testing Batch\\chromedriver1.exe");
		   
		WebDriver driver =new ChromeDriver();
		
		  return driver;  
	}
	
	public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Software Testing Batch\\geckodriver.exe");
		   
		WebDriver driver =new FirefoxDriver();
		
		  return driver;  
	}

}
