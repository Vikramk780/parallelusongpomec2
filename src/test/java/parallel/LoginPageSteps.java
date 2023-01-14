package parallel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import AlphaPages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	WebDriver ldriver;
	
	LoginPage loginPage;
	
	

@Given("user is on login page")
public void user_is_on_login_page() {
	ldriver =new ChromeDriver();
	ldriver.get("https://stageapp.botprise.com");
	loginPage = new LoginPage(ldriver);
	loginPage.doLogin();
}

@When("user gets title")
public void user_gets_title() {
	loginPage.getTitle();
}

@Then("title should be {string}")
public void title_should_be(String string) {
	String actualtitle =loginPage.titleVerify();
	Assert.assertEquals(actualtitle,string);
	ldriver.close();
}

}
