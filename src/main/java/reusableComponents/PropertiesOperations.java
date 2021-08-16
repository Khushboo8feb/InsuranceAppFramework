package reusableComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesOperations {
	
	static Properties prop = new Properties();
	
	public static String getPropertiesValueByKey(String key) throws Exception
	{
		//1. load data from properties file
		String propFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		FileInputStream fis = new FileInputStream(propFilePath);
		prop.load(fis);
		//2. Read data
		String keyValue = prop.getProperty(key);
		
		
		if(StringUtils.isEmpty(keyValue))
		{
			throw new Exception("Value is not specified for key:  "+key+ "  in properties file");
		}
		
		return keyValue;
		
	}

}
