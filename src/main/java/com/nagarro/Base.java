package com.nagarro;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.configuration2.Configuration;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Common;
import utils.enums.Config;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {
	public AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;
	public Configuration commonConfig = Common.getConfig(Config.COMMON);
	public Configuration anndroidConfig = Common.getConfig(Config.ANDROID);

	public void loadDriver(){
		File classpathRoot = new File(System.getProperty("user.dir"));

		File appDir = new File(classpathRoot, commonConfig.getString("APK_DIR"));
		File app = new File(appDir, commonConfig.getString("APK_NAME"));
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,commonConfig.getString("PLATFORM_NAME"));
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,commonConfig.getString("PLATFORM_VERSION"));
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,commonConfig.getString("DEVICE_NAME"));
		desiredCapabilities.setCapability(MobileCapabilityType.UDID,commonConfig.getString("UDID"));
		desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,commonConfig.getInt(
				"NEW_COMMAND_TIMEOUT"));
		desiredCapabilities.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		desiredCapabilities.setCapability("appPackage", anndroidConfig.getString("APP_PACKAGE"));
		desiredCapabilities.setCapability("appActivity", anndroidConfig.getString("APP_ACTIVITY"));
		try {
			URL url = new URL(commonConfig.getString("DRIVER_URL"));
			driver = new AndroidDriver<MobileElement>(url,desiredCapabilities);
			driver.manage().timeouts().implicitlyWait(commonConfig.getInt("TIMEOUT"), TimeUnit.SECONDS);
			wait = new WebDriverWait(driver,commonConfig.getInt("TIMEOUT"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void tearDown() {
		try {
			Thread.sleep(5000);
			driver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
