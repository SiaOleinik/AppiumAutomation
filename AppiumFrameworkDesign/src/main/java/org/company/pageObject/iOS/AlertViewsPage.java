package org.company.pageObject.iOS;

import org.company.utils.IOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViewsPage extends IOSActions{
	
	IOSDriver driver;
	
	public AlertViewsPage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertViews; 
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label == 'Text Entry'`]")
	private WebElement textEntry; 
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField")
	private WebElement textField; 
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`label == 'OK'`]")
	private WebElement oKButton; 
	
	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'ConFirm'" )
	WebElement submit;
	
	@iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH[c] 'A message'" )
	WebElement confirmMessage;
	
	
	public void fillInTextField(String text) {
		textEntry.click();
		textField.sendKeys(text);
		oKButton.click();
	}
	
	
	public void selectAlertViews() {
		alertViews.click();
	}
	
	public String getConfirmMessage() {
		submit.click();
		return confirmMessage.getText();
		
	}
	
}
