package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class OnlinePayment extends BaseTest {

	public OnlinePayment(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@name='name_on_card']")
	WebElement cName;
	@FindBy(xpath = "//*[@name='card_number']")
	WebElement cNum;

	@FindBy(xpath = "//*[@name='cvc']")
	WebElement cCvc;

	@FindBy(xpath = "//*[@name='expiry_month']")
	WebElement eMonth;

	@FindBy(xpath = "//*[@name='expiry_year']")
	WebElement Eyear;

	@FindBy(xpath = "//*[text()='Pay and Confirm Order']")
	WebElement pandplace;

	@FindBy(xpath = "//*[text()='Continue']")
	WebElement fContinue;

	public void UserCardName(String uname) {
		cName.sendKeys(uname);
	}

	public void UserCardNumber(String unumber) {
		cNum.sendKeys(unumber);
	}

	public void userCVC(String cv) {
		cCvc.sendKeys(cv);
	}

	public void UserExMonth(String expriyM) {
		eMonth.sendKeys(expriyM);
	}

	public void UserExYear(String experiYear) {
		Eyear.sendKeys(experiYear);
	}

	public void PayAndPlaceOrder() {
		pandplace.click();
	}

	public void Continue() {
		fContinue.click();
	}
}
