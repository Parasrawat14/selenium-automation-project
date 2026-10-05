package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Base.Basetest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class login1 extends Basetest {

	
	public void login() {

		System.out.println("enter");
		driver.findElement(By.id(loc.getProperty("userid"))).sendKeys("MG00001");
		driver.findElement(By.id(loc.getProperty("Passwords"))).sendKeys("MG00001");
		driver.findElement(By.xpath(loc.getProperty("Login"))).click();
		System.out.println("login");
	
	}
	
}
