package parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefs {

	@Given("Step from {string} in {string} feature file")
	public void step(String scenario, String file) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.format("Thread ID - %2d - %s from %s feature file.\n",
		Thread.currentThread().getId(), scenario,file);
		System.out.println("hello im closing browser");
		
		driver.get("https://stageapp.botprise.com");
		Thread.sleep(2000);
		driver.close();
	}
}