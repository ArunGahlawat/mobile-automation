package tests;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import com.nagarro.Base;

public class Test01 extends Base {

	@Test(description = "Hello world test 01")
	public void myTest01() {
		System.out.println("hello");
		wait.until(ExpectedConditions.elementToBeClickable(By.id(
				"in.amazon.mShop.android.shopping:id/skip_sign_in_button")));
		MobileElement skipSigninButton = driver.findElementById(
				"in.amazon.mShop.android.shopping:id/skip_sign_in_button");
		skipSigninButton.click();
		// search field in.amazon.mShop.android.shopping:id/search_edit_text
		// after tap -> in.amazon.mShop.android.shopping:id/search_auto_text

	}
}
