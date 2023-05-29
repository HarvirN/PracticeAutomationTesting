package AutomationTesting;

import static org.openqa.selenium.support.PageFactory.initElements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Utilities.Actions.*;

public class MyAccount {
	WebDriver driver;
	WebDriverWait wait;

	public MyAccount(WebDriver driver) {
		this.driver = driver;
		initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
	}

	// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	@FindBy(id = "reg_email")
	WebElement emailaddress;

	@FindBy(id = "reg_password")
	WebElement regPassword;

	@FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")
	WebElement Register;

	@FindBy(id = "username")
	WebElement Username;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")
	WebElement Login;

	@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")
	WebElement Logout;

	@FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/p[2]/label")
	WebElement FocusClick;
	
	

	public void Register(String username, String password) throws InterruptedException {
		EnterText(emailaddress, username);
		for(String s : password.split(""))
		{
			Thread.sleep(500);
			EnterText(regPassword, s);
		}
		//wait.until(ExpectedConditions.elementToBeClickable(Register));
		
		ClickElement(Register);
        
	}

	public void Login(String username,String password) throws InterruptedException {
		EnterText(Username, username);
		EnterText(Password, password);
	 wait.until(ExpectedConditions.elementToBeClickable(Login));
		ClickElement(Login);
	}

	public String WelcomeText() {
		String name = BaseClass.username.substring(0, BaseClass.username.indexOf('@'));
		return "Hello " + name + " (not " + name + "? Sign out)";
	}

	public void logout() {
		ClickElement(Logout);
	}

}
