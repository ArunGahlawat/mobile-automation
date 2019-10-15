package com.nagarro.locators;

public enum JobsFeedLocators {
	BUTTON_FILTER("in.workindia.nileshdungarwal.workindiaandroid:id/btn_filter"),
	BUTTON_SORT("in.workindia.nileshdungarwal.workindiaandroid:id/btn_sort"),
	BUTTON_SHARE("in.workindia.nileshdungarwal.workindiaandroid:id/action_share"),
	BUTTON_SYNC("in.workindia.nileshdungarwal.workindiaandroid:id/action_sync"),
	BUTTON_NOTIFICATIONS("in.workindia.nileshdungarwal.workindiaandroid:id/action_notifications"),
	;

	String locator;

	JobsFeedLocators(String locator) {
		this.locator = locator;
	}

	public String value() {
		return this.locator;
	}

}
