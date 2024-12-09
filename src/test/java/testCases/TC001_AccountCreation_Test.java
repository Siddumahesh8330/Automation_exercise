package testCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SignupAndLoginPage;
import testBase.BaseClass;

public class TC001_AccountCreation_Test extends BaseClass {

	@Test(groups = { "Regression", "Master", "Sanity" })
	public void verify_userAccount_creation() throws InterruptedException {

		// New user SignUp
		SignupAndLoginPage signup = new SignupAndLoginPage(driver);
		signup.clickSignup();
		signup.enterName(randomAlp().toLowerCase());
		signup.enterEmail(randomAlp() + "@gmail.com");
		signup.clickSignupbtn();

		// Enter Account Information
		signup.clickTitleGender();
		signup.Password(randomAlp() + "!123");

		// **Day**

		Select selDay = new Select(signup.selectday());
		selDay.selectByIndex(14);

		Select selMonth = new Select(signup.selectmonth());
		selMonth.selectByVisibleText("August");

		Select selyear = new Select(signup.selectyear());
		selyear.selectByVisibleText("1996");

		// checkBoxes
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 550)", "");
		signup.clickSettler();
		signup.clickOffers();

		// Address Informations
		signup.firstname(randomAlp());
		signup.lastname(randomAlp());
		signup.userCompnay(randomAlp().toUpperCase());
		signup.address1("8-" + randomAlp());
		signup.address2(randomAlp());

		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0, 550)", "");

		Select selCoun = new Select(signup.Usercountry());
		selCoun.selectByIndex(3);

		signup.state(randomAlp());
		signup.city(randomAlp());
		signup.zipcode(randomNum());
		signup.number(randomNum());
		signup.createbtn();

		// Account created validation
		String ACV = signup.AccountCreated();
		Assert.assertEquals(ACV, "ACCOUNT CREATED!");
		signup.clickContinue();
		signup.clickOnLogout();
	}

}
