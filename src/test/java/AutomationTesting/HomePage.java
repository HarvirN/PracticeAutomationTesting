package AutomationTesting;

import static org.openqa.selenium.support.PageFactory.initElements;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	@FindBy(xpath="//div[@id=\"n2-ss-6\"]//img[contains(@class,'n2-ss-slide-background-image')]")
	List<WebElement> slider;
	
	@FindBy(xpath="//div[@id=\"site-logo\"]//img")
	WebElement homepagelogo;
	
	@FindBy(xpath="//div[@id=\"n2-ss-6-arrow-next\"]//img[@class=\"n2-ow\"]")
	WebElement slidericon;
	
	public void homepagesliderdetails()
	{
		homepagelogo.click();
		List<String> slidersrcattributelist = new ArrayList<String>();
		for(int i=0;i<slider.size();i++)
		{
			WebElement s = slider.get(i);
			String slidersrc = s.getAttribute("src");
			slidersrcattributelist.add(i, slidersrc);
		}
		
		for(int i=0;i<slidersrcattributelist.size();i++)
		{    
			By by = By.xpath("(//div[@id='n2-ss-6']//img[contains(@class,'n2-ss-slide-background-image')])[" + i + 1 + "]");
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
			WebElement g = driver.findElement(by);
			String slidersrcverify = g.getAttribute("src");
		    assertEquals(slidersrcverify, slidersrcattributelist.get(i));
		    slidericon.click(); 
		}
	}
}
