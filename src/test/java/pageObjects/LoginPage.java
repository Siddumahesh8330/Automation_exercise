package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseTest {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@name='email']")
	WebElement enterEmail;

	@FindBy(xpath = "//*[@name='password']")
	WebElement enterpsd;

	@FindBy(xpath = "//form[@action='/login']//*[@class='btn btn-default']")
	WebElement sBtn;

	public void User_EmailAddress(String umail) {
		enterEmail.sendKeys(umail);
	}

	public void User_Password(String upsd) {
		enterpsd.sendKeys(upsd);
	}

	public void Click_SignInBtn() {
		sBtn.click();
	}

}
