package com.nagarro.locators;

public enum ProfileLocators {
	BUTTON_SECTION("//*[@class='android.widget.TextView' and @text='INDEX' and contains(@resource-id,'Label')]"),
	OPTION_PROFILE("//*[@class='android.widget.TextView' and @text='INDEX' and contains(@resource-id,'tv_menu')]"),
	BUTTON_EDIT_NAME("in.workindia.nileshdungarwal.workindiaandroid:id/iv_edit_name"),
	BUTTON_EDIT_ENGLISH_LEVEL("in.workindia.nileshdungarwal.workindiaandroid:id/et_speak_english_level"),
	OPTION_ENGLISH_LEVEL_1("in.workindia.nileshdungarwal.workindiaandroid:id/rg_eng_level_1"),
	OPTION_ENGLISH_LEVEL_2("in.workindia.nileshdungarwal.workindiaandroid:id/rg_eng_level_2"),
	OPTION_ENGLISH_LEVEL_3("in.workindia.nileshdungarwal.workindiaandroid:id/rg_eng_level_3"),
	OPTION_ENGLISH_LEVEL_4("in.workindia.nileshdungarwal.workindiaandroid:id/rg_eng_level_4"),
	BUTTON_SUBMIT_POPUP("android:id/button1"),
	BUTTON_PROFILE_UPDATE("in.workindia.nileshdungarwal.workindiaandroid:id/btn_profile_update"),
	BANNER_UPDATE_SUCCESSFUL("in.workindia.nileshdungarwal.workindiaandroid:id/snackbar_text"),
	TEXT_FIELD_FULL_NAME("in.workindia.nileshdungarwal.workindiaandroid:id/et_name"),
	TEXT_FIELD_MOBILE_NUMBER("in.workindia.nileshdungarwal.workindiaandroid:id/et_number"),
	TEXT_FIELD_EMAIL("in.workindia.nileshdungarwal.workindiaandroid:id/et_email"),
	BUTTON_DONE("in.workindia.nileshdungarwal.workindiaandroid:id/btn_done"),
	BUTTON_SKIP("in.workindia.nileshdungarwal.workindiaandroid:id/btn_skip"),
	TEXT_FULL_NAME("in.workindia.nileshdungarwal.workindiaandroid:id/tv_name"),
	TEXT_MOBILE_NUMBER("in.workindia.nileshdungarwal.workindiaandroid:id/tv_mobile_no");

	String locator;

	ProfileLocators(String locator) {
		this.locator = locator;
	}

	public String value() {
		return this.locator;
	}

}
