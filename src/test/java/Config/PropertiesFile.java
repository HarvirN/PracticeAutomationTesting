package Config;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile 
{
     public static Properties prop;
     
     
	public static void readpropertiesfile()
	{
		 prop = new Properties();
		try {
			FileInputStream input = new FileInputStream("C:\\Users\\HarvirN\\eclipse-workspace\\AutomationPractice\\src\\test\\java\\Config\\config.properties");
			prop.load(input);
	
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
   
