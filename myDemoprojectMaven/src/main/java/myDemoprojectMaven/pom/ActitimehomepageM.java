package myDemoprojectMaven.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimehomepageM {
	//Hi All
	Actions act;
	@FindBy (xpath = "(//img[@src='/img/default/pixel.gif?hash=1692528820'])[10]")
	private WebElement report;
	
	@FindBy (xpath = "(//img[@height='98'])[8]")
	private WebElement user;
	
	@FindBy (xpath = "//a[text()='Logout']")
	private WebElement logout;
	
	public ActitimehomepageM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}

	

	public void report() throws InterruptedException
	{
		Thread.sleep(3000);
		act.moveToElement(report).click().build().perform();
		
	}
	
	public void user() throws InterruptedException
	{
		Thread.sleep(3000);
		act.moveToElement(user).click().build().perform();
		
	}
	
	public void logout() throws InterruptedException
	{
		Thread.sleep(3000);
		logout.click();
	}


}
