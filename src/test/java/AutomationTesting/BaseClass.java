package AutomationTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Config.PropertiesFile;

public class BaseClass {
	static WebDriver driver;
	static String username = "Harvir16@gmail.com";
	static String password = "Harvir@123456789";
	 @BeforeMethod
	  public static void beforeMethod() {
		 PropertiesFile.readpropertiesfile();
		  switch (PropertiesFile.prop.getProperty("browser").toLowerCase())
			{		
			    case "chrome":
			    	driver = new ChromeDriver();
				break;
				
			    case "firefox":
					driver = new FirefoxDriver();
				break;
			} 
		//  Actions.before();
		 driver.manage().window().maximize();
		 driver.get(PropertiesFile.prop.getProperty("url"));
		 
	  }
	 @AfterMethod
	 public static void afterMethod()
	 {
		 driver.close();
	 }
}
