package Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	// ===================== Locators =====================

	By hrms = By.xpath("//*[@id='sideBar']/ul/li[2]/a");
	By addEmployee = By.xpath("//a[normalize-space()='Add Employee']");

	By firstName = By.name("employee.fName");
	By lastName = By.name("employee.lName");
	By fatherName = By.name("employee.fatherName");
	By gender = By.name("employee.gender");

	By dob = By.xpath("//*[@id='my-form']/div[1]/div[2]/div[5]/div/input[2]");

	By email = By.name("employee.email");
	By mobile = By.name("employee.mobile");
	By address = By.name("employee.address");

	By inTime = By.id("inTime");

	By outTime = By.xpath("//input[@type='text' and @placeholder='Select Out Time']");

	By department = By.name("employee.department");
	By designation = By.name("employee.designation");
	By shift = By.name("employee.shift");
	By reportingManager = By.name("employee.reporting_mgr");
	By employeeType = By.name("employee.empType");
	By role = By.name("employee.roleId");
	By location = By.name("employee.locationId");

	//By nextButton = By.cssSelector("button.next");

	By maritalStatus = By.name("personalDetails.marital_status");
	By bloodGroup = By.name("personalDetails.bloodGroup");
	By emergencyName = By.id("ecname");
	By emergencyNumber = By.id("ecn");

	By profilePhoto = By.xpath("//input[@type='file']");

	By aadhar = By.name("bankDetail.aadhar");

	By addressProof = By.name("add_prof");

	// ===================== Methods =====================


	
	
	public void openAddEmployee() {

		wait.until(ExpectedConditions.elementToBeClickable(hrms)).click();

		wait.until(ExpectedConditions.elementToBeClickable(addEmployee)).click();
	}

	public void enterBasicDetails() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys("Cris");

		driver.findElement(lastName).sendKeys("Ronl");

		driver.findElement(fatherName).sendKeys("xxxxx");

		Select genderSelect = new Select(driver.findElement(gender));
		genderSelect.selectByVisibleText("Male");
	}


	public void selectDOB() {

		wait.until(ExpectedConditions.elementToBeClickable(dob)).click();

		
		Select month = new Select(wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("flatpickr-monthDropdown-months"))));

		month.selectByVisibleText("August");

		WebElement year = driver.findElement(By.xpath("//input[@aria-label='Year']"));

		year.clear();
		year.sendKeys("2001");

		driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day') " + "and @aria-label='August 6, 2001']"))
				.click();
	}

	public void selectJoiningDate() {

		By joiningDate = By.xpath("//input[@type='text' and @placeholder='Select joining date']");

		wait.until(ExpectedConditions.elementToBeClickable(joiningDate)).click();

		Select month = new Select(wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("div.flatpickr-calendar.open " + "select.flatpickr-monthDropdown-months"))));

		month.selectByVisibleText("September");

		WebElement year = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div.flatpickr-calendar.open input.cur-year")));

		year.clear();
		year.sendKeys("2026");

		wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("div.flatpickr-calendar.open " + "span.flatpickr-day[aria-label='September 5, 2026']")))
				.click();
	}

	public void enterContactDetails() {

		driver.findElement(email).sendKeys("xyz@gmail.com");

		driver.findElement(mobile).sendKeys("8899960053");

		driver.findElement(address).sendKeys("1234 aa");
	}

	public void selectInTime() {

		wait.until(ExpectedConditions.elementToBeClickable(inTime)).click();

		WebElement hour = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Hour']")));

		hour.clear();
		hour.sendKeys("08");

		WebElement minute = driver.findElement(By.xpath("//input[@aria-label='Minute']"));

		minute.clear();
		minute.sendKeys("45");

		WebElement second = driver.findElement(By.xpath("//input[contains(@class,'flatpickr-second')]"));

		second.clear();
		second.sendKeys("12");
	}

	public void selectOutTime() {

		wait.until(ExpectedConditions.elementToBeClickable(outTime)).click();

		WebElement hour = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div.flatpickr-calendar.open input.flatpickr-hour")));

		hour.clear();
		hour.sendKeys("18");

		WebElement minute = driver.findElement(By.cssSelector("div.flatpickr-calendar.open input.flatpickr-minute"));

		minute.clear();
		minute.sendKeys("30");

		WebElement second = driver.findElement(By.cssSelector("div.flatpickr-calendar.open input.flatpickr-second"));

		second.clear();
		second.sendKeys("01");
	}

	public void selectEmployeeDetails() {

		new Select(driver.findElement(department)).selectByVisibleText("Plant");

		new Select (wait.until(ExpectedConditions.visibilityOfElementLocated(designation))).selectByVisibleText("Manager");
	//	new Select(driver.findElement(designation)).selectByVisibleText("Manager");

		new Select(driver.findElement(shift)).selectByVisibleText("Day");

		new Select(driver.findElement(reportingManager)).selectByValue("MG00001");

		new Select(driver.findElement(employeeType)).selectByVisibleText("Casual");

		new Select(driver.findElement(role)).selectByVisibleText("Employee");

		new Select(driver.findElement(location)).selectByVisibleText(" Greater Noida");
	}

	public void clickNextPage1() {
		WebElement nextButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'next')]")));
		nextButton.click();
	}

	// ===================== Personal Details =====================

	public void enterPersonalDetails() {

		new Select(driver.findElement(maritalStatus)).selectByVisibleText("Unmarried");

		new Select(driver.findElement(bloodGroup)).selectByVisibleText("B+");

		driver.findElement(emergencyName).sendKeys("Rahul");

		driver.findElement(emergencyNumber).sendKeys("9876543210");
	}

	public void uploadProfilePhoto() {

		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Profile.jpg";

		wait.until(ExpectedConditions.presenceOfElementLocated(profilePhoto)).sendKeys(filePath);
	}

	public void clickNextPage2() {
		List<WebElement> nextButtons = driver.findElements(By.cssSelector("button.next"));
		for (WebElement button : nextButtons) {
			if (button.isDisplayed() && button.isEnabled()) {
				button.click();
				break;
			}
		}
	}
	// ===================== Bank Details =====================

	public void enterAadhar() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(aadhar)).sendKeys("123456789012");
	}

	public void clickNextPage3() {
		List<WebElement> nextButtons = driver.findElements(By.cssSelector("button.next"));
		for (WebElement button : nextButtons) {
			if (button.isDisplayed() && button.isEnabled()) {
				button.click();
				break;
			}
		}
	}

	// ===================== Address Proof =====================

	public void uploadAddressProof() {

		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\address_Proof.pdf";

		wait.until(ExpectedConditions.presenceOfElementLocated(addressProof)).sendKeys(filePath);
	}

	public void clickSubmit() {
		WebElement submit = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@type='submit' and contains(@class,'btn-premium-success')]")));
		submit.click();

	}
}
