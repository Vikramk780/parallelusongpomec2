package AlphaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	@FindBy(xpath="//input[@id=\"email\"]") WebElement userName;
	@FindBy(xpath="//input[@id=\"password\"]") WebElement passWord;
	@FindBy(xpath="//strong[contains(text(),\"Login\")]") WebElement loginBtn;
	
		
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(ldriver, this);
	}
	
	public void doLogin() {
		userName.sendKeys("admin@botprise.com");
		passWord.sendKeys("BotpriseTeam2021$$");
		loginBtn.click();
	}
	
	public void getTitle() {
		String title =ldriver.getTitle();
	}
	
 public String titleVerify() {
	 String title =ldriver.getTitle();
	 return title;
 }
}
