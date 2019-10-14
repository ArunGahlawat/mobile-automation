package com.nagarro.stepDefinitions;

import com.nagarro.Base;
import com.nagarro.locators.SignupLocators;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Signup extends Base {

	private MobileElement fullName;
	private MobileElement mobileNumber;
	private MobileElement submitButton;

	@Given("App is launched")
	public void app_is_launched() {
		loadDriver();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupLocators.TEXT_FIELD_FULL_NAME.value())));
	}

	@When("^User input \"([^\"]*)\" as Full Name$")
	public void userInputAsFullName(String arg0){
		fullName = driver.findElementById(SignupLocators.TEXT_FIELD_FULL_NAME.value());
		fullName.sendKeys(arg0);
	}

	@And("^User input \"([^\"]*)\" as mobile number$")
	public void userInputAsMobileNumber(String arg0) {
		mobileNumber = driver.findElementById(SignupLocators.TEXT_FIELD_MOBILE_NUMBER.value());
		mobileNumber.sendKeys(arg0);
	}

	@And("^User clicks on submit button$")
	public void userClicksOnSubmitButton() {
		submitButton = driver.findElementById(SignupLocators.BUTTON_SUBMIT.value());
		submitButton.click();
	}

	@Then("^Verify Input is not accepted as valid input$")
	public void verifyInputIsNotAcceptedAsValidInput() {
		Assert.assertTrue(fullName.isDisplayed());
		Assert.assertTrue(mobileNumber.isDisplayed());
		Assert.assertTrue(submitButton.isDisplayed());
	}
}
