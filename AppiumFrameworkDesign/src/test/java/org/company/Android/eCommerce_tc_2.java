package org.company.Android;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.company.pageObject.android.CartPage;
import org.company.pageObject.android.FormPage;
import org.company.pageObject.android.ProductCatalogue;
import org.company.testUtils.AndroidBaseTest;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class eCommerce_tc_2 extends AndroidBaseTest {

	@Test(dataProvider="getData", groups= {"Smoke"})
	public void fillForm(HashMap<String, String> input) throws InterruptedException {
		
		FormPage formPage = new FormPage(driver);
		Thread.sleep(5000);
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountrySelection(input.get("country"));
		ProductCatalogue productCatalogue =formPage.submitForm();
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		CartPage cartPage = productCatalogue.goToCartPage();
		double totalSum = cartPage.getCartPrice();
		//double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		AssertJUnit.assertEquals(cartPage.getTotalAmountDisplayed(), totalSum);

		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
	}
	
	@BeforeMethod(alwaysRun=true)
	public void preSetup() {
		formPage.setActivity();	
		
	}
	@DataProvider
	public Object[][] getData() throws IOException{
		
		//return new Object[][] { {"Alicia Oleinik","male", "Angola"},{"Alicia Oleinik","female", "Argentina"} };
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"src/test/java/org/company/testData/eCommerce.json");
		return new Object[][] { {data.get(0)},{data.get(1)} };
	}

}
