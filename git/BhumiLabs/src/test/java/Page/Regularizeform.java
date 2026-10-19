
package Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Regularizeform {

	WebDriver driver;
	WebDriverWait wait;

	public Regularizeform(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	// ======================= Locators =============================

	By attendance = By.xpath("/html/body/div[1]/div/div/aside/ul/li[4]/a");

	By Datewiseattendance = By.xpath("//a[normalize-space()='Date-wise Attendance']");

	By regularizeform = By.xpath("//*[@id='attendanceTable']/tbody/tr[1]/td[14]/i");

	By changeTime = By.xpath("//*[@id='regularizeForm']/div[1]/div/label[2]");

	By inTimeInput = By.xpath("//input[@id='inTime']/following-sibling::input[@type='text']");

	By outTimeInput = By.xpath("//input[@id='outTime']/following-sibling::input[@type='text']");

	// ======================= Navigation =============================

	public void clickonattendance() {

		wait.until(ExpectedConditions.elementToBeClickable(attendance)).click();

		wait.until(ExpectedConditions.elementToBeClickable(Datewiseattendance)).click();
	}

	// ======================= Regularize Form =============================

	public void clickregularize() {

		wait.until(ExpectedConditions.elementToBeClickable(regularizeform)).click();

		wait.until(ExpectedConditions.elementToBeClickable(changeTime)).click();

		// ================= In Time: 09:30:00 =================

		wait.until(ExpectedConditions.elementToBeClickable(inTimeInput)).click();

		WebElement inHour = getOpenTimeField(By.xpath(".//input[@aria-label='Hour']"));

		WebElement inMinute = getOpenTimeField(By.xpath(".//input[@aria-label='Minute']"));

		WebElement inSecond = getOpenTimeField(By.xpath(".//input[contains(@class,'flatpickr-second')]"));

		setTimeByArrows(inHour, 9, 23);
		setTimeByArrows(inMinute, 30, 59);
		setTimeByArrows(inSecond, 0, 59);

		// ================= Out Time: 20:30:00 =================

		wait.until(ExpectedConditions.elementToBeClickable(outTimeInput)).click();

		WebElement outHour = getOpenTimeField(By.xpath(".//input[@aria-label='Hour']"));

		WebElement outMinute = getOpenTimeField(By.xpath(".//input[@aria-label='Minute']"));

		WebElement outSecond = getOpenTimeField(By.xpath(".//input[contains(@class,'flatpickr-second')]"));

		setTimeByArrows(outHour, 20, 23);
		setTimeByArrows(outMinute, 30, 59);
		setTimeByArrows(outSecond, 0, 59);
	}

	// ======================= Find Open Flatpickr Field ==================================================
	

	private WebElement getOpenTimeField(By fieldLocator) {

		By openCalendar = By.xpath("//div[contains(@class,'flatpickr-calendar') " + "and contains(@class,'open')]");

		WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(openCalendar));

		return wait.until(driver -> calendar.findElement(fieldLocator));
	}

	// ======================= Set Time Using Arrows =============================

	public void setTimeByArrows(WebElement input, int target, int maxValue) {

		WebElement wrapper = input.findElement(By.xpath(".."));

		By upArrow = By.cssSelector("span.arrowUp");
		By downArrow = By.cssSelector("span.arrowDown");

		for (int i = 0; i <= maxValue; i++) {

			int current = Integer.parseInt(input.getAttribute("value"));

			if (current == target) {
				return;
			}

			WebElement arrow = wrapper.findElement(current < target ? upArrow : downArrow); 
			// If the current value is smaller than the target, select the up arrow ,Otherwise, select the down arrow.
			
			wait.until(ExpectedConditions.elementToBeClickable(arrow)).click();
		}

		throw new RuntimeException("Could not set time field to " + target);
	}
	//============================== Shift and Location and remark =============================================================
	public void select() 
	{
		Select shift = new Select(wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"missingShift1\"]"))));
		
		shift.selectByVisibleText("Day");
		
		Select location = new Select(wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"location\"]"))));
		
		location.selectByVisibleText("Outdoor");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"remark\"]"))).sendKeys("QWEEHASBDJAJDBJBSDJKA");
	}
	
}
