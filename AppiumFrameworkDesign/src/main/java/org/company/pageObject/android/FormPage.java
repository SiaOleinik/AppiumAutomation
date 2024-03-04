package org.company.pageObject.android;

import org.company.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {

	AndroidDriver driver;

	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement femailOption;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;

	@AndroidFindBy(id = "android:id/text1")
	private WebElement selectCountry;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement submitButton;

	public void setNameField(String name) {

		nameField.sendKeys(name);
		driver.hideKeyboard();
	}

	public void setActivity() {
		// in terminal adb shell dumpsys window | grep -E 'mCurrentFocus'

		Activity activity = new Activity("com.androidsample.generalstore",
				"com.androidsample.generalstore.SplashActivity");
		driver.startActivity(activity);
	}

	public void setGender(String gender) {

		if (gender.equalsIgnoreCase("male")) {
			maleOption.click();
		} else if (gender.equalsIgnoreCase("female")) {
			femailOption.click();
		}
	}

	public void setCountrySelection(String country) {
		selectCountry.click();
		scrollToTextAction2(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + country + "']")).click();

	}

	public ProductCatalogue submitForm() {
		submitButton.click();
		return new ProductCatalogue(driver);
	}

//	
}
