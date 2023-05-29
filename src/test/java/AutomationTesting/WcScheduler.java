package AutomationTesting;

import static org.openqa.selenium.support.PageFactory.initElements;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Actions;

import static Utilities.Actions.*;

public class WcScheduler 
{
WebDriver driver;
WebDriverWait wait;

public WcScheduler(WebDriver driver)
{
	this.driver = driver;
	initElements(driver, this);
	wait = new WebDriverWait(driver, Duration.ofSeconds(60));
}

@FindBy(xpath = "//*[@id=\"inner-nav-menu\"]/ul/li[1]")
WebElement scheduleEnc;

@FindBy(xpath = "//*//*[@class=\"v-select__slot\"]/input[1]")
WebElement findPatient;

@FindBy(xpath = "//div[@class='v-list-item__content']/div/span")
WebElement selectpatient;

@FindBy(id = "startVisitDate")
WebElement visitdate;

@FindBy(id = "visit-create-update-button")
WebElement createupdatebutton;

@FindBy(xpath = "//*[@class=\"hide-for-print\"]/a")
WebElement editvisit;





public void createVisit() throws InterruptedException
{
	wait.until(ExpectedConditions.elementToBeClickable(scheduleEnc));
	scheduleEnc.click();
	wait.until(ExpectedConditions.elementToBeClickable(findPatient));
	String patient = "James";
//	for(String s : patient.split(""))
//	{
//		Thread.sleep(500);
//		EnterText(findPatient, s);
//	}
       EnterText(findPatient,"james");
   	wait.until(ExpectedConditions.visibilityOf(selectpatient));       
	wait.until(ExpectedConditions.textToBePresentInElement(selectpatient,"James, Johnson k. - 01/04/2006"));
	selectpatient.click();
	//Thread.sleep(10000);
	//visitdate.click();
	waitForLoader(driver);
	visitdate.click();
	visitdate.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
	//Thread.sleep(10000);
    EnterText(visitdate, currentDate());
	wait.until(ExpectedConditions.elementToBeClickable(createupdatebutton));
	createupdatebutton.click();
}


public void editVisit() throws IOException
{
	//waitForLoader(driver);
	//wait.until(ExpectedConditions.visibilityOf(editvisit)); 
	//editvisit.click();
	
	readFromExcel("VisitDate");
	
}

}
