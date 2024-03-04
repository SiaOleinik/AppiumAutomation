package org.company.IOS;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.company.pageObject.iOS.AlertViewsPage;
import org.company.testUtils.IOSBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest {

	@Test
	public void iOSBasicsTest() throws InterruptedException  {
		
		AlertViewsPage alertViewsPage = homePage.selectAlertViews();
		alertViewsPage.fillInTextField("Hello World");
		String actualMessage =	alertViewsPage.getConfirmMessage();
		AssertJUnit.assertEquals(actualMessage, "A message should be a short, complete sentence.");
		

		
		
	
	}

}
