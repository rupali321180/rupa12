package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Propertyfile {
@Test
	// TODO Auto-generated method stub


public void fetchprop() throws FileNotFoundException, IOException {
	Properties p=new Properties();
	p.load(new FileInputStream("C:\\Eclipse\\javaly\\src\\config\\config.Properties"));
	System.out.println(p.getProperty("browser"));
	
}
}
