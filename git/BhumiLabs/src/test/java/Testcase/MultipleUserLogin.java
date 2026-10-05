
package Testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Basetest;

public class MultipleUserLogin extends Basetest {

	@Test(dataProvider = "testdata")
	public void login(String username, String password) {

		System.out.println("Testing login for: " + username);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Enter Username
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc.getProperty("userid")))).sendKeys(username);

		// Enter Password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc.getProperty("Passwords"))))
				.sendKeys(password);

		// Click Login
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("Login")))).click();

		System.out.println("Login successful/attempted for: " + username);

		
		
	}

	@DataProvider(name = "testdata")
	public Object[][] testData() {

		return new Object[][] { { "MG00001", "MG00001" }, { "MPS00001", "MPS00001" }, { "BL00000", "BL00000" } };
	}
}
