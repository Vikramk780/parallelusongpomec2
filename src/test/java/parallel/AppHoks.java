package parallel;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ApphaUtil.ConfigReader;
import alpha.drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHoks {

	ConfigReader configReader;
	Properties prop;
	DriverFactory driverFactory;
	String browsername;
	 WebDriver driver;
	
	@Before(order=0)
	public void init_prop() throws IOException {
		configReader = new ConfigReader();
		prop=configReader.init_properties();
		browsername=prop.getProperty("browser");
	}
	
	@Before(order=1)
	public void init_browser(){
		driverFactory=new DriverFactory();
		driverFactory.init_Driver(browsername);
		
		
	}
	
	@After(order=0)
	public void quit() {
		driverFactory.getDriver().quit();
	}
	@After(order=1)
	public void tearDown(Scenario sc) {
		if(sc.isFailed()){
		String sceanrioname=sc.getName().replaceAll(" ", "_");
		byte[] sourceofscrennshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(sourceofscrennshot, "image/png", sceanrioname);
			
		}
	}
}
