package com.nagarro.stepDefinitions;

import com.nagarro.Base;
import com.nagarro.locators.JobsFeedLocators;
import com.nagarro.locators.ProfileLocators;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Profile extends Base {

	@And("^Job feeds section is open$")
	public void jobFeedsSectionIsOpen() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(JobsFeedLocators.BUTTON_SORT.value())));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(JobsFeedLocators.BUTTON_FILTER.value())));
	}

	@When("^User goes to \"([^\"]*)\" section$")
	public void userGoesToSection(String arg0) {
		String profileSectioXpath = ProfileLocators.BUTTON_SECTION.value().replaceAll("INDEX", arg0);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(profileSectioXpath)));
		MobileElement desiredSection = driver.findElementByXPath(profileSectioXpath);
		desiredSection.click();
	}

	@And("^Selects my profile option$")
	public void selectsMyProfileOption() {
		String profileSectioXpath = ProfileLocators.OPTION_PROFILE.value().replaceAll("INDEX", "My Profile");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(profileSectioXpath)));
		MobileElement desiredMenuItem = driver.findElementByXPath(profileSectioXpath);
		desiredMenuItem.click();
	}

	@And("^Selects English fluency to \"([^\"]*)\"$")
	public void selectsEnglishFluencyTo(String arg0) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(ProfileLocators.BUTTON_EDIT_ENGLISH_LEVEL.value())));
		MobileElement buttonEnglishFluancy = driver.findElementById(ProfileLocators.BUTTON_EDIT_ENGLISH_LEVEL.value());
		buttonEnglishFluancy.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ProfileLocators.OPTION_ENGLISH_LEVEL_3.value())));
		MobileElement englishLevel;
		switch (arg0.toUpperCase().trim()) {
			case "NO ENGLISH":
				englishLevel = driver.findElementById(ProfileLocators.OPTION_ENGLISH_LEVEL_1.value());
				break;
			case "THODA ENGLISH":
				englishLevel = driver.findElementById(ProfileLocators.OPTION_ENGLISH_LEVEL_2.value());
				break;
			case "GOOD ENGLISH":
				englishLevel = driver.findElementById(ProfileLocators.OPTION_ENGLISH_LEVEL_3.value());
				break;
			case "FLUENT ENGLISH":
				englishLevel = driver.findElementById(ProfileLocators.OPTION_ENGLISH_LEVEL_4.value());
				break;
			default:
				throw new InvalidArgumentException("Invalid english level provided");
		}
		englishLevel.click();
		MobileElement popupButton = driver.findElementById(ProfileLocators.BUTTON_SUBMIT_POPUP.value());
		popupButton.click();
	}

	@And("^Clicks on Update profile button$")
	public void clicksOnUpdateProfileButton() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(ProfileLocators.BUTTON_EDIT_ENGLISH_LEVEL.value())));
		swipeDown();
		swipeDown();
		MobileElement updateProfileButton = driver.findElementById(ProfileLocators.BUTTON_PROFILE_UPDATE.value());
		Assert.assertTrue(updateProfileButton.isDisplayed() && updateProfileButton.isEnabled());
		updateProfileButton.click();
	}

	@Then("^Verify profile is updated successfully$")
	public void verifyProfileIsUpdatedSuccessfully() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ProfileLocators.BANNER_UPDATE_SUCCESSFUL.value())));
		MobileElement updateProfileMessage = driver.findElementById(ProfileLocators.BANNER_UPDATE_SUCCESSFUL.value());
		System.out.println(updateProfileMessage.getText());
	}

	@And("^Clicks on edit profile link$")
	public void clicksOnEditProfileLink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ProfileLocators.BUTTON_EDIT_NAME.value())));
		MobileElement editBasicProfileButton = driver.findElementById(ProfileLocators.BUTTON_EDIT_NAME.value());
		editBasicProfileButton.click();
	}

	@And("^updates Full name to \"([^\"]*)\"$")
	public void updatesFullNameTo(String arg0) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ProfileLocators.TEXT_FIELD_FULL_NAME.value())));
		MobileElement fullName = driver.findElementById(ProfileLocators.TEXT_FIELD_FULL_NAME.value());
		fullName.sendKeys(arg0);
	}

	@And("^updates Mobile number to \"([^\"]*)\"$")
	public void updatesMobileNumberTo(String arg0) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ProfileLocators.TEXT_FIELD_MOBILE_NUMBER.value())));
		MobileElement mobileNumber = driver.findElementById(ProfileLocators.TEXT_FIELD_MOBILE_NUMBER.value());
		mobileNumber.sendKeys(arg0);
	}

	@And("^Clicks on DONE$")
	public void clicksOnDONE() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ProfileLocators.BUTTON_DONE.value())));
		driver.findElementById(ProfileLocators.BUTTON_DONE.value()).click();
	}

	@Then("^Verify full name is updated as \"([^\"]*)\" and mobile number is updated as \"([^\"]*)\"$")
	public void verifyFullNameIsUpdatedAsAndMobileNumberIsUpdatedAs(String arg0, String arg1) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ProfileLocators.TEXT_MOBILE_NUMBER.value())));
		MobileElement mobileNumberText = driver.findElementById(ProfileLocators.TEXT_MOBILE_NUMBER.value());
		MobileElement realNameText = driver.findElementById(ProfileLocators.TEXT_FULL_NAME.value());
		Assert.assertEquals(arg0.toUpperCase().trim(), realNameText.getText().toUpperCase().trim());
		Assert.assertEquals(arg1.trim(), mobileNumberText.getText().trim());
	}
}
