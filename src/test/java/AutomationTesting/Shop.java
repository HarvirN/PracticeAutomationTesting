package AutomationTesting;

import static org.openqa.selenium.support.PageFactory.initElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shop {
	 WebDriver driver;
	  WebDriverWait wait;
	  
	  
	  public Shop(WebDriver driver)
	  {
		   this.driver = driver;
		   initElements(driver, this);
		    wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	  }
	  
@FindBy(xpath="//*[@id=\"content\"]/ul/li[4]/a[1]/img")	  
WebElement BookTitlePage;

@FindBy(className="input-text")
WebElement Quantity;

@FindBy(xpath="//*[@id=\"product-182\"]/div[2]/form/button")
WebElement AddToBasket;

@FindBy(className="cartcontents")
WebElement GoToCart;

@FindBy(className= "cart_item")
WebElement cartitems;

@FindBy(xpath= "//*[@id=\"menu-item-40\"]/a")
WebElement ShopNavigation;

@FindBy(xpath="//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[6]/span")
WebElement TotalCartValue;

@FindBy(xpath="//*[@id=\"product-182\"]/div[2]/div[1]/p/span")
WebElement BookAmount;

@FindBy(xpath="//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[4]/span")
WebElement CartBookAmount;

public void AddBookToCart()
{   
	//driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
	ShopNavigation.click();
//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BookTitlePage);
	BookTitlePage.click();
	Quantity.clear();
	Quantity.sendKeys("1");
//	String a = Quantity.getAttribute("value");
//	String b = BookAmount.getText();
//	b.substring(1);
	AddToBasket.click();
}
	  
public String TotalCartValue()
{
	GoToCart.click();
	String s = TotalCartValue.getText();
//	s.substring(1);
	return(s);
}

public String CartBookPrice()
{
	GoToCart.click();
	String c = CartBookAmount.getText();
//	s.substring(1);
	return(c);
}

public boolean result()
{
	GoToCart.click();
	String s = TotalCartValue.getText().substring(1,3);
	String c = CartBookAmount.getText().substring(1,3);
	boolean b = c.equals(s);
	return b;
}
}


