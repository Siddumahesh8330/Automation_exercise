package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddProductToCarts;
import pageObjects.LoginPage;
import pageObjects.OnlinePayment;
import pageObjects.SignupAndLoginPage;
import testBase.BaseClass;

public class TC005_End_To_End_Test extends BaseClass {
	@Test(groups = "master")
	public void Verify_CreateRegister_And_PlaceOrder() throws Throwable {

		logger.info("*** TC005_Starting Test Cases_ ***");
		try {
			SignupAndLoginPage signup = new SignupAndLoginPage(driver);
			signup.clickSignup();
			logger.info("*** TC005_Clicked On Create Sign in Button_  ***");
			String finalEmail = randomEmail();
			String finalpassword = randomPassword();
			signup.enterName(randomAlp().toLowerCase());
			signup.enterEmail(finalEmail);
			signup.clickSignupbtn();
			logger.info("*** TC005_Entering User Details_  ***");
			signup.clickTitleGender();
			signup.Password(finalpassword);
			Select selDay = new Select(signup.selectday());
			selDay.selectByIndex(14);
			Select selMonth = new Select(signup.selectmonth());
			selMonth.selectByVisibleText("August");
			Select selyear = new Select(signup.selectyear());
			selyear.selectByVisibleText("1996");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 550)", "");
			signup.clickSettler();
			signup.clickOffers();
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
			logger.info("*** TC005_Account Successfully Created_  ***");
			// Account created validation
			String ACV = signup.AccountCreated();
			Assert.assertEquals(ACV, "ACCOUNT CREATED!");
			signup.clickContinue();
			signup.clickOnLogout();
			signup.clickSignup();
			logger.info("*** TC005_Logging With Created UserName and Password_  ***");
			LoginPage lp = new LoginPage(driver);
			lp.User_EmailAddress(finalEmail);
			lp.User_Password(finalpassword);
			lp.Click_SignInBtn();
			logger.info("*** TC005_Account Successfully Logged in_  ***");
			signup.clickOnLogout();
			signup.clickSignup();
			lp.User_EmailAddress(finalEmail);
			lp.User_Password(finalpassword);
			lp.Click_SignInBtn();
			logger.info("*** TC005_Adding Products To Cart_  ***");
			AddProductToCarts add = new AddProductToCarts(driver);
			JavascriptExecutor jsss = (JavascriptExecutor) driver;
			jsss.executeScript("window.scrollBy(0, 500)", "");
			add.AddItemOne();
			add.SelectQuantity(p.getProperty("quantiy"));
			add.AddToCart();
			Thread.sleep(3000);
			add.ContinueShopping();
			driver.navigate().back();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0, 1000)", "");
			add.AddItemTwo();
			Thread.sleep(5000);
			add.SelectQuantity(p.getProperty("quantiy"));
			add.AddToCart();
			add.ViewCart();
			add.ProceedToCheckOut();
			JavascriptExecutor jseexe = (JavascriptExecutor) driver;
			jseexe.executeScript("window.scrollBy(0, 1300)", "");
			Thread.sleep(3000);
			logger.info("*** TC005_Proceed To Check Out_  ***");
			add.PlaceOrder();
			logger.info("*** TC005_Entering Card Details_  ***");
			OnlinePayment op = new OnlinePayment(driver);
			op.UserCardName(p.getProperty("Name"));
			op.UserCardNumber(p.getProperty("cardNumber"));
			op.userCVC(p.getProperty("CVC"));
			op.UserExMonth(p.getProperty("ExMonth"));
			op.UserExYear(p.getProperty("ExYear"));
			op.PayAndPlaceOrder();
			op.Continue();
			logger.info("*** TC005_Order Got Place Successfully_  ***");
			signup.clickOnLogout();
			logger.info("*** TC005_Account Logged Out_  ***");
		} catch (Exception e) {
			logger.error("Test failed");
			Assert.fail();
		}
		logger.info("*** TC005_Test Case Finished_  ***");
	}
}
