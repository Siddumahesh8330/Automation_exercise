package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupAndLoginPage extends BaseTest {

	public SignupAndLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[starts-with(text(),' Signup / Login')]")
	WebElement signANDLogin;

	@FindBy(name = "name")
	WebElement sign_name;

	@FindBy(xpath = "//*[@data-qa='signup-email']")
	WebElement sign_emailaddress;

	@FindBy(xpath = "//button[contains(text(),'Signup')]")
	WebElement sign_Signup;

	@FindBy(id = "id_gender1")
	WebElement sign_Gender;

	@FindBy(id = "password")
	WebElement sign_Pswd;

	@FindBy(id = "days")
	WebElement sign_Day;

	@FindBy(id = "months")
	WebElement sign_month;

	@FindBy(xpath = "//*[@id='years']")
	WebElement sign_years;

	@FindBy(xpath = "//*[contains(text(),'Address Information')]")
	WebElement addressinfrmation;

	@FindBy(xpath = "//*[@name='newsletter']")
	WebElement sign_newsettler;

	@FindBy(xpath = "//*[@id='optin']")
	WebElement sign_offers;

	@FindBy(xpath = "//*[@id='first_name']")
	WebElement fname;

	@FindBy(xpath = "//*[@id='last_name']")
	WebElement lname;

	@FindBy(xpath = "//*[@id='company']")
	WebElement company;

	@FindBy(xpath = "//*[@id='address1']")
	WebElement address1;

	@FindBy(xpath = "//*[@id='address2']")
	WebElement address2;

	@FindBy(xpath = "//*[@id='country']")
	WebElement country;

	@FindBy(xpath = "//*[@id='state']")
	WebElement state;

	@FindBy(xpath = "//*[@id='city']")
	WebElement city;

	@FindBy(xpath = "//*[@id='zipcode']")
	WebElement zipcode;

	@FindBy(xpath = "//*[@id='mobile_number']")
	WebElement Number;

	@FindBy(xpath = "//button[@data-qa='create-account']")
	WebElement createAccount;

	@FindBy(xpath = "//*[contains(text(),'Account Created!')]")
	WebElement acccountsuccessfullyCreated;

	@FindBy(xpath = "//*[contains(text(),'Continue')]")
	WebElement continu;

	@FindBy(xpath = "//*[@href='/logout']")
	WebElement logout;

	public void clickSignup() {
		signANDLogin.click();

	}

	public void enterName(String UserName) {
		sign_name.sendKeys(UserName);
	}

	public void enterEmail(String userEmail) {
		sign_emailaddress.sendKeys(userEmail);
	}

	public void clickSignupbtn() {
		sign_Signup.click();
	}

	public void clickTitleGender() {
		sign_Gender.click();
	}

	public void Password(String userPass) {
		sign_Pswd.sendKeys(userPass);
	}

	public WebElement selectday() {
		// sign_Day.click();
		return sign_Day;

	}

	public WebElement selectmonth() {
		// sign_month.click();
		return sign_month;
	}

	public WebElement selectyear() {
		sign_years.click();
		return sign_years;
	}

	public void clickSettler() {
		sign_newsettler.click();
		
	}

	public void AddressInformation() {
		addressinfrmation.click();
		
	}

	public void clickOffers() {
		sign_offers.click();
	}

	public void firstname(String firsName) {
		fname.sendKeys(firsName);
	}

	public void lastname(String lastName) {
		lname.sendKeys(lastName);
	}

	public void userCompnay(String Cpany) {
		company.sendKeys(Cpany);
	}

	public void address1(String add1) {
		address1.sendKeys(add1);
	}

	public void address2(String add2) {
		address2.sendKeys(add2);
	}

	public WebElement Usercountry() {
		country.click();
		return country;
	}

	public void state(String Userstate) {
		state.sendKeys(Userstate);
	}

	public void city(String Usercity) {
		city.sendKeys(Usercity);
	}

	public void zipcode(String code) {
		zipcode.sendKeys(code);
	}

	public void number(String mobile) {
		Number.sendKeys(mobile);
	}

	public void createbtn() {
		createAccount.click();
	}

	public void clickContinue() {
		continu.click();
	}

	public void clickOnLogout() {
		logout.click();
	}

	public String AccountCreated() {
		try {
			return (acccountsuccessfullyCreated.getText());
		} catch (Exception e) {
			return e.getMessage();
		}

	}
}
