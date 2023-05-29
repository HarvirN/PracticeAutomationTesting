package AutomationTesting;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners (AutomationTesting.TestStatusListener.class)
public class TestCases1 extends BaseClass
{
	

	@BeforeMethod
	public void maximizeScreenmethod()
	{
		driver.manage().window().maximize();
		System.out.println("Screen maximized in tesst");
		ScreenMaximize s = new ScreenMaximize();
		s.maximizeScreenmethod();
	}
	
	@Test (enabled = false)//(priority=1 ,dependsOnMethods = {"UserLogin"})
	public void RegisterUser() throws InterruptedException {
		MyAccount myaccount = new MyAccount(driver);
	    myaccount.Register(username, password);
		String s = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[2]")).getText();
		assertEquals(s, myaccount.WelcomeText());
		myaccount.logout();
		myaccount.Login(username,password);
	}

	@Test //(priority=2)
	public void UserLogin() throws InterruptedException {
		MyAccount myaccount = new MyAccount(driver);
		//Shop shopobj = new Shop(driver);
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
