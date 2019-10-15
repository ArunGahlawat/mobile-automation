package com.nagarro.stepDefinitions;

import com.nagarro.Base;
import com.nagarro.locators.SignupLocators;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Signup extends Base {

	private MobileElement fullName;
	private MobileElement mobileNumber;
	private MobileElement submitButton;
	private MobileElement personalDetailsSubmitButton;
	private MobileElement skillsButton;
	private MobileElement coursesButton;


	@Given("App is launched")
	public void app_is_launched() {
		loadDriver();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupLocators.TEXT_FIELD_FULL_NAME.value())));
	}

	@When("^User input \"([^\"]*)\" as Full Name$")
	public void userInputAsFullName(String arg0) {
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

	@When("^User provides basic details$")
	public void userProvidesBasicDetails() {
		userInputAsFullName("Test User 123");
		userInputAsMobileNumber("9011111111");
		userClicksOnSubmitButton();
	}

	@And("^User selects city as \"([^\"]*)\"$")
	public void userSelectsCityAs(String arg0) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupLocators.BUTTON_PUNE.value())));
		MobileElement cityButton;
		switch (arg0.toUpperCase().trim()) {
			case "MUMBAI":
				cityButton = driver.findElementById(SignupLocators.BUTTON_MUMBAI.value());
				break;
			case "PUNE":
				cityButton = driver.findElementById(SignupLocators.BUTTON_PUNE.value());
				break;
			case "DELHI":
				cityButton = driver.findElementById(SignupLocators.BUTTON_DELHI.value());
				break;
			case "BENGALURU":
				cityButton = driver.findElementById(SignupLocators.BUTTON_BENGALURU.value());
				break;
			default:
				throw new InvalidArgumentException("Invalid city provided");
		}
		cityButton.click();
	}

	@And("^User input \"([^\"]*)\" as Nearest location$")
	public void userInputAsNearestLocation(String arg0) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupLocators.TEXT_FIELD_NEAREST_LOCATION.value())));
		MobileElement nearestLocation = driver.findElementById(SignupLocators.TEXT_FIELD_NEAREST_LOCATION.value());
		nearestLocation.sendKeys(arg0);
	}

	@And("^User submit city selection$")
	public void userSubmitCitySelection() {
		MobileElement citySubmitButton = driver.findElementById(SignupLocators.BUTTON_CITY_SUBMIT.value());
		Assert.assertTrue(citySubmitButton.isDisplayed() && citySubmitButton.isEnabled());
		citySubmitButton.click();
	}

	@And("^User selects gender as \"([^\"]*)\"$")
	public void userSelectsGenderAs(String arg0) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupLocators.BUTTON_GENDER_FEMALE.value())));
		MobileElement gender;
		switch (arg0.toUpperCase().trim()) {
			case "MALE":
				gender = driver.findElementById(SignupLocators.BUTTON_GENDER_MALE.value());
				break;
			case "FEMALE":
				gender = driver.findElementById(SignupLocators.BUTTON_GENDER_FEMALE.value());
				break;
			default:
				throw new InvalidArgumentException("Invalid gender provided");
		}
		gender.click();
	}

	@And("^User selects qualification as \"([^\"]*)\"$")
	public void userSelectsQualificationAs(String arg0) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupLocators.BUTTON_QUALIFICATION_10.value())));
		MobileElement qualification;
		switch (arg0.toUpperCase().trim()) {
			case "BELOW 10TH PASS":
				qualification = driver.findElementById(SignupLocators.BUTTON_QUALIFICATION_BELOW_10.value());
				break;
			case "10TH PASS":
				qualification = driver.findElementById(SignupLocators.BUTTON_QUALIFICATION_10.value());
				break;
			case "12TH PASS & ABOVE":
				qualification = driver.findElementById(SignupLocators.BUTTON_QUALIFICATION_12_ABOVE.value());
				break;
			case "GRADUATE":
				qualification = driver.findElementById(SignupLocators.BUTTON_QUALIFICATION_GRADUATE.value());
				break;
			default:
				throw new InvalidArgumentException("Invalid qualification provided");
		}
		qualification.click();
	}

	@And("^User selects school medium as \"([^\"]*)\"$")
	public void userSelectsSchoolMediumAs(String arg0) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupLocators.BUTTON_SCHOOL_MEDIUM_ENGLISH.value())));
		MobileElement medium;
		switch (arg0.toUpperCase().trim()) {
			case "ENGLISH":
				medium = driver.findElementById(SignupLocators.BUTTON_SCHOOL_MEDIUM_ENGLISH.value());
				break;
			case "HINDI":
				medium = driver.findElementById(SignupLocators.BUTTON_SCHOOL_MEDIUM_HINDI.value());
				break;
			case "OTHERS":
				medium = driver.findElementById(SignupLocators.BUTTON_SCHOOL_MEDIUM_OTHER.value());
				break;
			default:
				throw new InvalidArgumentException("Invalid Medium provided");
		}
		medium.click();
	}

	@And("^User selects english speaking level as \"([^\"]*)\"$")
	public void userSelectsEnglishSpeakingLevelAs(String arg0) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupLocators.BUTTON_ENGLISH_LEVEL_3.value())));
		MobileElement englishLevel;
		switch (arg0.toUpperCase().trim()) {
			case "NO ENGLISH":
				englishLevel = driver.findElementById(SignupLocators.BUTTON_ENGLISH_LEVEL_1.value());
				break;
			case "THODA ENGLISH":
				englishLevel = driver.findElementById(SignupLocators.BUTTON_ENGLISH_LEVEL_2.value());
				break;
			case "GOOD ENGLISH":
				englishLevel = driver.findElementById(SignupLocators.BUTTON_ENGLISH_LEVEL_3.value());
				break;
			case "FLUENT ENGLISH":
				englishLevel = driver.findElementById(SignupLocators.BUTTON_ENGLISH_LEVEL_4.value());
				break;
			default:
				throw new InvalidArgumentException("Invalid english level provided");
		}
		englishLevel.click();
	}

	@And("^User selects \"([^\"]*)\" as Experience$")
	public void userSelectsAsExperience(String arg0) {
		swipeDown();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupLocators.BUTTON_EXPERIENCE_FRESHER.value())));
		MobileElement experience;
		switch (arg0.toUpperCase().trim()) {
			case "FRESHER":
				experience = driver.findElementById(SignupLocators.BUTTON_EXPERIENCE_FRESHER.value());
				break;
			case "EXPERIENCE":
				experience = driver.findElementById(SignupLocators.BUTTON_EXPERIENCE_EXPERIENCED.value());
				break;
			default:
				throw new InvalidArgumentException("Invalid experience provided");
		}
		experience.click();
	}

	@And("^User input age as \"([^\"]*)\"$")
	public void userInputAgeAs(String arg0) {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(SignupLocators.TEXT_FIELD_AGE.value())));
		MobileElement age = driver.findElementById(SignupLocators.TEXT_FIELD_AGE.value());
		age.sendKeys(arg0);
	}

	@And("^User selects \"([^\"]*)\" as Interest area$")
	public void userSelectsAsInterestArea(String arg0) {
		swipeDown();
		String interestAreaXpath = SignupLocators.BUTTON_INTEREST_XPATH.value().replaceAll("INDEX", arg0);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(interestAreaXpath)));
		MobileElement interestArea = driver.findElementByXPath(interestAreaXpath);
		interestArea.click();
	}

	@And("^User submit personal details$")
	public void userSubmitPersonalDetails() {
		personalDetailsSubmitButton = driver.findElementById(SignupLocators.BUTTON_SUBMIT_DETAILED_PROFILE.value());
		personalDetailsSubmitButton.click();
	}

	@Then("^Verify details are submitted successfully$")
	public void verifyDetailsAreSubmittedSuccessfully() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupLocators.BUTTON_SKILLS.value())));
		skillsButton = driver.findElementById(SignupLocators.BUTTON_SKILLS.value());
		Assert.assertTrue(skillsButton.isDisplayed());
		coursesButton = driver.findElementById(SignupLocators.BUTTON_COURSE.value());
		Assert.assertTrue(coursesButton.isDisplayed());
	}

	@And("^User is registered$")
	public void userIsRegistered() {
		userProvidesBasicDetails();
		userSelectsCityAs("Delhi");
		userInputAsNearestLocation("Karol Bagh");
		userSubmitCitySelection();
		userSelectsGenderAs("female");
		userSelectsQualificationAs("graduate");
		userSelectsSchoolMediumAs("english");
		userSelectsEnglishSpeakingLevelAs("FLUENT ENGLISH");
		userSelectsAsExperience("Fresher");
		userInputAgeAs("23 Years");
		userSelectsAsInterestArea("Back Office");
		userSubmitPersonalDetails();
		verifyDetailsAreSubmittedSuccessfully();
		skillsButton.click();
		String skillsXpath = SignupLocators.CHECKBOX_SKILLS.value().replaceAll("INDEX", "MS Word");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(skillsXpath)));
		MobileElement selectedSkillButton = driver.findElementByXPath(skillsXpath);
		selectedSkillButton.click();
		MobileElement popupSubmitButton = driver.findElementById(SignupLocators.BUTTON_SKILL_POPUP_SUBMIT.value());
		popupSubmitButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupLocators.BUTTON_COURSE.value())));
		coursesButton.click();
		String coursesXpath = SignupLocators.RADIO_QUALIFICATION.value().replaceAll("INDEX", "BA");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(coursesXpath)));
		MobileElement selectedCourseButton = driver.findElementByXPath(coursesXpath);
		selectedCourseButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupLocators.BUTTON_SUBMIT_DETAILED_PROFILE.value())));
		personalDetailsSubmitButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignupLocators.BUTTON_LANGUAGE_ENGLISH.value())));
		MobileElement appLanguage = driver.findElementById(SignupLocators.BUTTON_LANGUAGE_ENGLISH.value());
		appLanguage.click();
	}
}
