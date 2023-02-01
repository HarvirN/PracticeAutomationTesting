package AutomationTesting;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestCases2 extends BaseClass {
	@Test
	public void AddBookToCart() throws InterruptedException
	{   
		MyAccount myaccountobj = new MyAccount(driver);
		Shop shopobj = new Shop(driver);
		//username = "Harvir10@gmail.com";
		myaccountobj.Login(username,password);
		shopobj.AddBookToCart();
		Boolean resultvalue = shopobj.result();
		assertTrue(resultvalue);
		
	}
}


