package Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AttendancePage

{

	WebDriver driver;
	WebDriverWait wait;

	public AttendancePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	// Locator

	By attendance = By.xpath("/html/body/div[1]/div/div/aside/ul/li[4]/a");
	By Datewiseattendance = By.xpath("//a[normalize-space()='Date-wise Attendance']");
	By fromdate = By.xpath("//input[@placeholder='From date' and @type='text']");
	By todate = By.xpath("//input[@placeholder='To date'and @type='text']");
	By idname = By.xpath("//select[@id='employeeSelect']");

	// methods

	public void clickattendance() {
		wait.until(ExpectedConditions.elementToBeClickable(attendance)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Datewiseattendance)).click();

	}

	public void date() {
		wait.until(ExpectedConditions.elementToBeClickable(fromdate)).click();

		Select months = new Select(wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("flatpickr-monthDropdown-months"))));
		months.selectByContainsVisibleText("August");

		WebElement year = driver.findElement(By.xpath("//input[@aria-label='Year']"));

		year.clear();
		year.sendKeys("2026");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-label='August 14, 2026']"))).click();

	}

	public void todate() {

		// Open To Date calendar
		wait.until(ExpectedConditions.elementToBeClickable(todate)).click();

		// Locate Month dropdown inside the open calendar
		By month = By.xpath("//div[contains(@class,'flatpickr-calendar') "
				+ "and contains(@class,'open')]//select[@aria-label='Month']");

		WebElement monthDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(month));

		new Select(monthDropdown).selectByVisibleText("August");

		/*
		 * // Locate Year input inside the open calendar By year =
		 * By.xpath("//div[contains(@class,'flatpickr-calendar') " +
		 * "and contains(@class,'open')]//input[@aria-label='Year']");
		 * 
		 * WebElement yearInput =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(year));
		 * 
		 * // yearInput.clear(); yearInput.sendKeys("2026");
		 * 
		 * 
		 * 
		 */ // Select date
		By date = By.xpath("//div[contains(@class,'flatpickr-calendar') "
				+ "and contains(@class,'open')]//span[@aria-label='August 31, 2026']");

		wait.until(ExpectedConditions.elementToBeClickable(date)).click();
	}

	public void employeeid() {
		/*
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(idname));
		 * 
		 * Select emp = new Select(driver.findElement(idname));
		 * emp.selectByVisibleText("MG0001 - MK Chauhan");
		 */
		 wait.until(ExpectedConditions.visibilityOfElementLocated(idname));

		    Select emp = new Select(driver.findElement(idname));

		    emp.selectByValue("MG00001");	
	}
}
