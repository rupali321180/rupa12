package popuppackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Script1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","./resourccess/geckodriver.exe");
		FirefoxOptions opt=new FirefoxOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new FirefoxDriver(opt);
		driver.get("https://www.facebook.com/");
	}
	
	
}
