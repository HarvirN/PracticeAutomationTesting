package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {
	static WebDriver driver;
	static int WAIT_TIMEOUT = 30;
	public static WebDriverWait wait;
	
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
	 
	 public static String currentDate()
	 {
	 	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	 	Date date = new Date();
	 	String currentdate = dateFormat.format(date);
	 	return currentdate;
	 }
	 
	 public static void waitForLoader(WebDriver driver)
	 {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'overlay')]")));
	 }
	 
	 public static String readFromExcel(String columnname) throws IOException
	 {
		 String excelpath = ".\\Data Files\\test excel.xlsx";
	    
		 FileInputStream inputstream = new FileInputStream(excelpath);  
		 XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		 XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		 for(Row row : sheet)
		 { 
			 for (Cell cell : row)
			 { 
				 if(cell.getStringCellValue().trim().equals(columnname))
				 { 
					 int rownum = row.getRowNum() +1;
					 int cellnum = cell.getColumnIndex();
					 XSSFCell a = sheet.getRow(rownum).getCell(cellnum);
					String data = a.getStringCellValue();
					System.out.println(data);
					return data;
				 } 
			 } 
		 }
		return null;
	 }
}
		


