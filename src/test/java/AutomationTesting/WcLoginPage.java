package AutomationTesting;

import static Utilities.Actions.EnterText;
import static org.openqa.selenium.support.PageFactory.initElements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WcLoginPage 
{
    WebDriver driver;
    WebDriverWait wait; 
public WcLoginPage(WebDriver driver)
{
	this.driver = driver;
	initElements(driver, this);
	wait = new WebDriverWait(driver, Duration.ofSeconds(60));
}

@FindBy(id="Username")
WebElement usernamefield;

@FindBy(id="Password")
WebElement passwordfield;

@FindBy(id="FacilityId")
WebElement facility;

@FindBy(id="Login")
WebElement loginbutton;

@FindBy(xpath ="//div[@id=\"requiredSignaturesModal\"]/p/input")
WebElement closepopup;

public void Login(String username,String password) 
{
	EnterText(usernamefield, username);
	EnterText(passwordfield, password);
	loginbutton.click();
	Select drpCountry = new Select(facility);
	drpCountry.selectByVisibleText("harvir's Facility");
	loginbutton.click();
	wait.until(ExpectedConditions.visibilityOf(closepopup));
	closepopup.click();
}
}
