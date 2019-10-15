package com.nagarro.locators;

public enum SignupLocators {
	TEXT_FIELD_FULL_NAME("in.workindia.nileshdungarwal.workindiaandroid:id/et_name"),
	TEXT_FIELD_MOBILE_NUMBER("in.workindia.nileshdungarwal.workindiaandroid:id/et_number"),
	BUTTON_SUBMIT("in.workindia.nileshdungarwal.workindiaandroid:id/btn_submit"),
	LINK_REFERRAL_CODE("in.workindia.nileshdungarwal.workindiaandroid:id/tv_referral_code"),
	TEXT_WELCOME_USER("in.workindia.nileshdungarwal.workindiaandroid:id/tv_city"),
	BUTTON_MUMBAI("in.workindia.nileshdungarwal.workindiaandroid:id/rb_mum"),
	BUTTON_PUNE("in.workindia.nileshdungarwal.workindiaandroid:id/rb_pune"),
	BUTTON_DELHI("in.workindia.nileshdungarwal.workindiaandroid:id/rb_delhi"),
	BUTTON_BENGALURU("in.workindia.nileshdungarwal.workindiaandroid:id/rb_bengaluru"),
	TEXT_FIELD_NEAREST_LOCATION("in.workindia.nileshdungarwal.workindiaandroid:id/act_auto_complete"),
	BUTTON_CITY_SUBMIT("in.workindia.nileshdungarwal.workindiaandroid:id/btn_done"),
	BUTTON_GENDER_MALE("in.workindia.nileshdungarwal.workindiaandroid:id/rg_male"),
	BUTTON_GENDER_FEMALE("in.workindia.nileshdungarwal.workindiaandroid:id/rg_female"),
	BUTTON_QUALIFICATION_BELOW_10("in.workindia.nileshdungarwal.workindiaandroid:id/rb_below_tenth"),
	BUTTON_QUALIFICATION_10("in.workindia.nileshdungarwal.workindiaandroid:id/rb_ssc"),
	BUTTON_QUALIFICATION_12_ABOVE("in.workindia.nileshdungarwal.workindiaandroid:id/rb_hsc"),
	BUTTON_QUALIFICATION_GRADUATE("in.workindia.nileshdungarwal.workindiaandroid:id/rb_graduate"),
	BUTTON_SCHOOL_MEDIUM_ENGLISH("in.workindia.nileshdungarwal.workindiaandroid:id/cb_english"),
	BUTTON_SCHOOL_MEDIUM_HINDI("in.workindia.nileshdungarwal.workindiaandroid:id/cb_hindi"),
	BUTTON_SCHOOL_MEDIUM_OTHER("in.workindia.nileshdungarwal.workindiaandroid:id/cb_other"),
	BUTTON_ENGLISH_LEVEL_1("in.workindia.nileshdungarwal.workindiaandroid:id/rg_eng_level_1"),
	BUTTON_ENGLISH_LEVEL_2("in.workindia.nileshdungarwal.workindiaandroid:id/rg_eng_level_2"),
	BUTTON_ENGLISH_LEVEL_3("in.workindia.nileshdungarwal.workindiaandroid:id/rg_eng_level_3"),
	BUTTON_ENGLISH_LEVEL_4("in.workindia.nileshdungarwal.workindiaandroid:id/rg_eng_level_4"),
	BUTTON_EXPERIENCE_FRESHER("in.workindia.nileshdungarwal.workindiaandroid:id/cb_fresher"),
	BUTTON_EXPERIENCE_EXPERIENCED("in.workindia.nileshdungarwal.workindiaandroid:id/cb_experience"),
	TEXT_FIELD_AGE("in.workindia.nileshdungarwal.workindiaandroid:id/et_age"),
	BUTTON_INTEREST_XPATH("//*[@class='android.widget.CheckBox' and @text='INDEX']"),
	BUTTON_SUBMIT_DETAILED_PROFILE("in.workindia.nileshdungarwal.workindiaandroid:id/btn_done"),
	BUTTON_SKILLS("in.workindia.nileshdungarwal.workindiaandroid:id/et_skill_1"),
	BUTTON_COURSE("in.workindia.nileshdungarwal.workindiaandroid:id/et_course"),
	CHECKBOX_SKILLS("//*[@resource-id='in.workindia.nileshdungarwal.workindiaandroid:id/tv_name' and @text='INDEX']"),
	BUTTON_SKILL_POPUP_SUBMIT("android:id/button1"),
	RADIO_QUALIFICATION("//*[@resource-id='android:id/text1' and @text='INDEX']"),
	BUTTON_LANGUAGE_ENGLISH("in.workindia.nileshdungarwal.workindiaandroid:id/btn_english"),
	BUTTON_LANGUAGE_HINDI("in.workindia.nileshdungarwal.workindiaandroid:id/btn_hindi"),
	;

	String locator;

	SignupLocators(String locator) {
		this.locator = locator;
	}

	public String value() {
		return this.locator;
	}

}
