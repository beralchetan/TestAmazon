package myDemoprojectMaven.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeloginpageM {
	@FindBy (xpath = "//input[@type='text']")
	private WebElement username;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath = "//a[@id='loginButton']")
	private WebElement login;
	
	public ActitimeloginpageM(WebDriver driver1)
	{
		PageFactory.initElements(driver1, this);
	}

	public void username(String u)
	{
		username.sendKeys(u);
	}
	
	public void password(String v)
	{
		password.sendKeys(v);
	}
	
	public void login() throws InterruptedException
	{
		Thread.sleep(3000);
		login.click();
	}


}
