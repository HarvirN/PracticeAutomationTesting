package AutomationTesting;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCases1 extends BaseClass {
	// WebDriver driver;
	// PropertiesFile.readpropertiesfile();
	
	

	@Test
	public void RegisterUser() throws InterruptedException {
		//username = "Harvir10@gmail.com";
		//password = "Harvir@123456789";
		MyAccount myaccount = new MyAccount(driver);
	    myaccount.Register(username, password);
		String s = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]")).getText();
		assertEquals(s, myaccount.WelcomeText());
		myaccount.logout();
		myaccount.Login(username,password);
	}

	@Test
	public void UserLogin() throws InterruptedException {
		MyAccount myaccount = new MyAccount(driver);
		Shop shopobj = new Shop(driver);
		// driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]")).click();
		//username = "Harvir10@gmail.com";
		myaccount.Login(username,password);
		// shopobj.AddBookToCart();
		// shopobj.Cart();
		// shopobj.result();
		//Boolean resultvalue = shopobj.result();
		//assertTrue(resultvalue);
		// myaccount.Logout();
	}

}
