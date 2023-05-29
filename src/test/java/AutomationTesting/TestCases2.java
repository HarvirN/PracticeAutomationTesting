package AutomationTesting;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners (AutomationTesting.TestStatusListener.class)
public class TestCases2 extends BaseClass {
	@Test
	public void AddBookToCart() throws InterruptedException
	{   
		MyAccount myaccountobj = new MyAccount(driver);
		Shop shopobj = new Shop(driver);
		myaccountobj.Login(username,password);
		shopobj.AddBookToCart();
		Boolean resultvalue = shopobj.result();
		assertTrue(resultvalue);
	}
	
	@Test
	public void verifyTheSlidersOnHomePage()
	{
		HomePage homepageobj = new HomePage(driver);
		homepageobj.homepagesliderdetails();
	}
	
	@Test
	public void verifyFilterByPrice()
	{
		Shop shopobj = new Shop(driver);
		shopobj.filterByPrice();
	}
}


