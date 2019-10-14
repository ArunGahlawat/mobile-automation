package com.nagarro.locators;

public enum SignupLocators {
	TEXT_FIELD_FULL_NAME("in.workindia.nileshdungarwal.workindiaandroid:id/et_name"),
	TEXT_FIELD_MOBILE_NUMBER("in.workindia.nileshdungarwal.workindiaandroid:id/et_number"),
	BUTTON_SUBMIT("in.workindia.nileshdungarwal.workindiaandroid:id/btn_submit"),
	LINK_REFERRAL_CODE("in.workindia.nileshdungarwal.workindiaandroid:id/tv_referral_code"),
	;

	String locator;
	SignupLocators(String locator) {
		this.locator = locator;
	}

	public String value() {
		return this.locator;
	}

}
