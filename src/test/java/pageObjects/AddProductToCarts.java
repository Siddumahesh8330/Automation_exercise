package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToCarts extends BaseTest {
	public AddProductToCarts(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@href='/product_details/1']")
	WebElement addItem1;

	@FindBy(xpath = "//*[@id='quantity']")
	WebElement qty;

	@FindBy(xpath = "//*[@type='button']/i")
	WebElement aCartBtn;

	@FindBy(xpath = "//*[text()='Continue Shopping']")
	WebElement cShopping;

	@FindBy(xpath = "//*[@href='/product_details/11']")
	WebElement addItem2;

	@FindBy(xpath = "//*[@href='/view_cart']/u")
	WebElement gotoCart;

	@FindBy(xpath = "//*[text()='Proceed To Checkout']")
	WebElement checkOut;

	@FindBy(xpath = "//*[text()='Place Order']")
	WebElement pOrder;

	public void AddItemOne() {
		addItem1.click();

	}

	public void SelectQuantity(String sq) {
		qty.clear();
		qty.sendKeys(sq);
	}

	public void AddToCart() {
		aCartBtn.click();
	}

	public void ContinueShopping() {
		cShopping.click();
	}

	public void AddItemTwo() {
		addItem2.click();
	}

	public void ViewCart() {
		gotoCart.click();
	}

	public void ProceedToCheckOut() {
		checkOut.click();
	}

	public void PlaceOrder() {
		pOrder.click();
	}
}
