package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.AddProductToCarts;
import pageObjects.LoginPage;
import pageObjects.SignupAndLoginPage;
import testBase.BaseClass;

public class TC003_Add_Products_To_Carts_Test extends BaseClass {

	@Test(groups = {"Master"})
	public void Verify_Add_Item_T0_Carts() throws Throwable {

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
		Thread.sleep(3000);
		add.ProceedToCheckOut();
		
		JavascriptExecutor jseexe = (JavascriptExecutor) driver;
		jseexe.executeScript("window.scrollBy(0, 1300)", "");
		add.PlaceOrder();
		signup.clickOnLogout();

	}

}
