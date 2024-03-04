package org.company.pageObject.android;

import java.util.List;

import org.company.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class CartPage extends AndroidActions {

	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> cartPrices;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement terms;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement acceptButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;
	
	@AndroidFindBy(className ="android.widget.CheckBox")
	private WebElement checkBox;
	
	public double getCartPrice() {
		int count = cartPrices.size();
		double FtotalCart = 0;
		
		for(int i = 0; i< count; i++) {
			String prodPrice = cartPrices.get(i).getText();
			Double price = getFormattedStringToDouble(prodPrice);;
			FtotalCart = FtotalCart+price;
			}
		
		return FtotalCart;
	}
	
	public Double getTotalAmountDisplayed() {
		
		return getFormattedAmount(totalAmount.getText());
	}
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public  void acceptTermsConditions() {
		longPressAction(terms);
		acceptButton.click();
	}
	
	public void submitOrder() {
		checkBox.click();
		proceed.click();
	}
	
//	Thread.sleep(5000);
//	String cartTot = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();	
//	double cartTotal = getFormattedStringToDouble(cartTot);
//	Assert.assertEquals(FtotalCart, cartTotal);
	
	
}
