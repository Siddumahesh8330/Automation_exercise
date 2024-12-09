package testCases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.SignupAndLoginPage;
import testBase.BaseClass;

public class TC002_Login_Test extends BaseClass {
	@Test(groups = {"Sanity","Master"})
	public void Verify_Login() {
		SignupAndLoginPage signup = new SignupAndLoginPage(driver);
		signup.clickSignup();

		LoginPage lp = new LoginPage(driver);
		lp.User_EmailAddress(p.getProperty("username"));
		lp.User_Password(p.getProperty("password"));
		lp.Click_SignInBtn();

		signup.clickOnLogout();

	}
}
