package AutomationTesting;


import org.testng.annotations.BeforeMethod;

public class ScreenMaximize extends BaseClass {

	@BeforeMethod
	public void maximizeScreenmethod()
	{
		driver.manage().window().maximize();
		System.out.println("Screen maximized from class");
	}
	
}
