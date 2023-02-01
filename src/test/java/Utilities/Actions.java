package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Actions {
	static WebDriver driver;
	public static WebElement EnterText(WebElement element,String text) {
		 element.sendKeys(text);
		 return element;
	}

	/*public static WebElement ClickElement(By by, WebDriver driver) {
		 WebElement element = driver.findElement(by);
		 element.click();
		 return element;
	 }
	*/ 
	
	public static WebElement ClickElement(WebElement element ) 
	{
	 element.click();
	 return element;
}

		
}

