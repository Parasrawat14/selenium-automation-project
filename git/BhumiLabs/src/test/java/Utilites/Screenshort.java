package Utilites;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Base.Basetest;
import Page.AddEmployee;

public class Screenshort {
	
	 public static void getScreenshot(WebDriver driver) throws IOException {

	        Date currentdate = new Date();

	        String screenshotfilename = currentdate.toString()
	                .replace(":", "-")
	                .replace(" ", "-");

	        File screenshot = ((TakesScreenshot) driver)
	                .getScreenshotAs(OutputType.FILE);

	        FileUtils.copyFile(
	                screenshot,
	                new File("./src/test/resources/reports/screenshots/"
	                        + screenshotfilename + ".png")
	        );
	    }
}

