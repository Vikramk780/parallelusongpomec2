package alpha.drivers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver init_Driver(String browser) {

	
	if(browser.equals("chrome")) {
		System.out.println("Hey buddy you are using chrome driver");
		WebDriverManager.chromedriver().setup();
		
		tlDriver.set(new ChromeDriver());
	}else if(browser.equals("firefox")) {
		System.out.println("Hey buddy you are using firefox driver");
		WebDriverManager.firefoxdriver().setup();
		tlDriver.set(new FirefoxDriver());
	}else {
		System.out.println("Please enter proper browser value--you hav forgotten to add");
	}
	
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	return getDriver();
}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
}
