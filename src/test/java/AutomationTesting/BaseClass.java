package AutomationTesting;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Config.PropertiesFile;
import ListenerUtility.MyListener;

public class BaseClass {
	static WebDriver driver;
	static String username = "Hnanuan";
	static String password = "Password!12345";
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest method;


	@BeforeTest
	public void beforeTest() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
        extent.attachReporter(spark);
	}

	@BeforeClass
	public void beforeClass()
	{
		test = extent.createTest(getClass().getSimpleName());
	}
	
	@BeforeMethod
	//@Parameters({"Browser"})
	//public static void beforeMethod(Method methodName, String browserName)  -- To use Parameters
	public static void beforeMethod(Method methodName)
	{
		method = test.createNode(methodName.getName());
		PropertiesFile.readpropertiesfile();
		switch (PropertiesFile.prop.getProperty("browser").toLowerCase()) {
		//switch (browserName.toLowerCase()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless=new");
			options.addArguments("--remote-allow-origins=*");

			//options.setHeadless(true);
			driver = new ChromeDriver(options);
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;
		}
		// Actions.before();
		EventFiringWebDriver event_driver = new EventFiringWebDriver(driver);
		MyListener listener = new MyListener();
		event_driver.register(listener);

		driver = event_driver;

		//driver.manage().window().maximize();

		driver.get(PropertiesFile.prop.getProperty("url1"));
	}

	 @AfterMethod
	 public static void afterMethod()
	 {
		 driver.close();
	 }
	 
	 @AfterTest
	 public static void afterClass()
	 {
		 extent.flush();
	 }
	 
	 @DataProvider
	 public Object[][] dataProvider(Object obj[][])
	 {
		 Object[][] a = obj;
		 return obj;
	 }

	public void failedScreenshot(String testMethodName) {
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile,
					new File("C:\\Users\\HarvirN\\eclipse-workspace\\AutomationPractice\\Screenshots\\" + testMethodName + ".png"));
			method.addScreenCaptureFromPath("C:\\Users\\HarvirN\\eclipse-workspace\\AutomationPractice\\Screenshots\\" + testMethodName + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
