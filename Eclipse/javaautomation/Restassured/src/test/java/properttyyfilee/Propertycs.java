package properttyyfilee;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Propertycs {

	@Test
	public String gett(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./property file/data.properties");
		
		Properties p=new Properties();
		p.load(fis);
		String url=p.getProperty(key);
		return url;
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
