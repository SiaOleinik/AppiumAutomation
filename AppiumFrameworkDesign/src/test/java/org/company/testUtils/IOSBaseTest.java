package org.company.testUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.company.pageObject.iOS.HomePage;
import org.company.utils.AppiumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest extends AppiumUtils{

	public IOSDriver driver;
	public AppiumDriverLocalService service;
	public HomePage homePage;

	@BeforeClass
	public void ConfigureAppium() throws IOException {
	
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/org/company/resources/data.properties");
		prop.load(fis);
		String ipAddress = "ipAddress";
		String port = "port";
		service = startAppiumServer(ipAddress, Integer.parseInt(port));

		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("IOSDeviceName");
		options.setApp(System.getProperty("user.dir")+"/src/test/java/org/company/resources/UIKitCatalog.app");
		//options.setApp("/Users/olesiaoleinik/eclipse-workspace/Appium/src/test/java/resources/TestApp 3.app");
		options.setPlatformVersion("16.0");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		
		
		driver = new IOSDriver(service.getUrl(), options); //new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homePage = new HomePage(driver);

	}

	@AfterMethod
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();

	}

}
