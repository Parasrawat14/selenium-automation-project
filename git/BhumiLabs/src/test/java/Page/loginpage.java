package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.Basetest;

public class loginpage extends Basetest {

	WebDriver driver;

	By userid = By.id(Basetest.loc.getProperty("userid"));
	By Password = By.id(Basetest.loc.getProperty("Passwords"));
	By loginButton = By.xpath(Basetest.loc.getProperty("Login"));

	public loginpage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String username, String password) {

		driver.findElement(userid).sendKeys(username);

		driver.findElement(Password).sendKeys(password);

		driver.findElement(loginButton).click();
	}
}
