package org.company.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppiumUtils {

	IOSDriver driver;

	public IOSActions(IOSDriver driver) {
		
		//super(driver);
		this.driver = driver;
	}

	public void longPressAction(WebElement ele) {
		
		Map<String,Object> params = new HashMap<>();
		params.put("element", ((RemoteWebElement)ele).getId());
		params.put("duration",5);
		driver.executeScript("mobile:touchAndHold", params);

	}

	public void scrollToWebElementAction(WebElement ele) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("element", ((RemoteWebElement) ele).getId());
		params.put("direction", "down");
		driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));

	}

	public void scrollToTextAction2(String text) {

	}

	public void scrollToEndAction() {

	}

	public void swipeAction(WebElement ele, String direction) {
		
		Map<String, Object> params2 = new HashMap<>();
		params2.put("direction", "left");
		driver.executeScript("mobile:swipe", params2);

	}

}
