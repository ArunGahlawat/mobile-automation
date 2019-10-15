package com.nagarro;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.configuration2.Configuration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Common;
import utils.enums.Config;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Base {
	protected static AppiumDriver<MobileElement> driver;
	protected static WebDriverWait wait;
	private Configuration commonConfig = Common.getConfig(Config.COMMON);
	private Configuration androidConfig = Common.getConfig(Config.ANDROID);

	protected static void swipeDown() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int x = 15;
		int top_y = (int) (height * 0.80);
		int bottom_y = (int) (height * 0.20);
		TouchAction ts = new TouchAction(driver);
		ts.press(new PointOption().withCoordinates(x, top_y)).moveTo(new PointOption().withCoordinates(x, bottom_y))
				.release().perform();
	}

	public static void swipeUp() {
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int x = 15;
		int top_y = (int) (height * 0.80);
		int bottom_y = (int) (height * 0.20);
		TouchAction ts = new TouchAction(driver);
		ts.press(new PointOption().withCoordinates(x, bottom_y)).moveTo(new PointOption().withCoordinates(x, top_y))
				.release().perform();
	}

	protected void loadDriver() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, androidConfig.getString("APK_DIR"));
		File app = new File(appDir, androidConfig.getString("APK_NAME"));
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, commonConfig.getString("PLATFORM_NAME"));
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, commonConfig.getString("PLATFORM_VERSION"));
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, commonConfig.getString("DEVICE_NAME"));
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, commonConfig.getString("UDID"));
		desiredCapabilities.setCapability(
				MobileCapabilityType.NEW_COMMAND_TIMEOUT, commonConfig.getInt("NEW_COMMAND_TIMEOUT"));
		desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		desiredCapabilities.setCapability("appPackage", androidConfig.getString("APP_PACKAGE"));
		desiredCapabilities.setCapability("appActivity", androidConfig.getString("APP_ACTIVITY"));
		try {
			URL url = new URL(commonConfig.getString("DRIVER_URL"));
			driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
			wait = new WebDriverWait(driver, commonConfig.getInt("TIMEOUT"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void tearDown() {
		try {
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
