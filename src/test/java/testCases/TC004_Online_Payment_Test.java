package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.AddProductToCarts;
import pageObjects.LoginPage;
import pageObjects.OnlinePayment;
import pageObjects.SignupAndLoginPage;
import testBase.BaseClass;

public class TC004_Online_Payment_Test extends BaseClass {
	@Test(groups = {"Regression","Master"})
	public void Verify_Online_Transcation_Details() throws InterruptedException {

		SignupAndLoginPage signup = new SignupAndLoginPage(driver);
		signup.clickSignup();

		LoginPage lp = new LoginPage(driver);
		lp.User_EmailAddress(p.getProperty("username"));
		lp.User_Password(p.getProperty("password"));
		lp.Click_SignInBtn();

		AddProductToCarts add = new AddProductToCarts(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)", "");
		add.AddItemOne();

		add.SelectQuantity(p.getProperty("quantiy"));
		add.AddToCart();
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
		add.PlaceOrder();

		OnlinePayment op = new OnlinePayment(driver);
		op.UserCardName(p.getProperty("Name"));
		op.UserCardNumber(p.getProperty("cardNumber"));
		op.userCVC(p.getProperty("CVC"));
		op.UserExMonth(p.getProperty("ExMonth"));
		op.UserExYear(p.getProperty("ExYear"));
		op.PayAndPlaceOrder();
		op.Continue();

		signup.clickOnLogout();
	}

}
