package com.nagarro.hooks;

import com.nagarro.Base;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static com.google.common.io.Files.copy;

public class Hooks extends Base {
	@Before
	public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor("Shivani");
		Reporter.addScenarioLog("Starting execution of : " + scenario.getName());
	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName =
					scenario.getName().replaceAll(" ", "_").substring(0, 30) + "_"
							+ UUID.randomUUID().toString().substring(0, 20) + ".png";
			try {
				//This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				File destinationCopyPath = new File("TestReport/scr/" + screenshotName);

				//Copy taken screenshot from source location to destination location
				copy(sourcePath, destinationCopyPath);
				File destinationReportPath = new File("scr/" + screenshotName);

				//This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationReportPath.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@After(order = 0)
	public void tearDownHook() {
		tearDown();
	}
}
