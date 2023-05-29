package AutomationTesting;


import java.io.PrintWriter;
import java.io.StringWriter;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestStatusListener extends BaseClass implements ITestListener 
{
   public void onTestFailure(ITestResult result)
   {
	   System.out.println("Test Case Failed");
	   try
	   {
		   failedScreenshot(result.getName());
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   
	   StringWriter sw = new StringWriter();
	   PrintWriter pw = new PrintWriter(sw);
	  // result.getThrowable().getStackTrace().toString()
	   result.getThrowable().printStackTrace(pw);
	   String trace = sw.toString();
	   BaseClass.method.fail(MarkupHelper.createLabel("Stack Trace ----------", ExtentColor.AMBER));
	   BaseClass.method.fail(trace);
   }
}
