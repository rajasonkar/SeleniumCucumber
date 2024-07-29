package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataFromPropertyFile {

	Properties prop = new Properties();
	public  String readData(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream("src//test//resources//TestData.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	
}
