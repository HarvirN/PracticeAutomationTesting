package AutomationTesting;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class WcTestCases extends BaseClass
{
	
	
	@Test
	public void createVisit() throws InterruptedException, IOException
	{
		WcLoginPage wcloginpageobj = new WcLoginPage(driver);
		WcScheduler wcscheduler = new WcScheduler(driver);
		wcloginpageobj.Login(username, password);
		//wcscheduler.createVisit();
		wcscheduler.editVisit();
	}
	
}