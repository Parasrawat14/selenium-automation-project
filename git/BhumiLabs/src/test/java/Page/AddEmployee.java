package Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Basetest;
import Testcase.login1;

public class AddEmployee extends Basetest {

	@Test
	public void addEmployee() {

		login1 login = new login1();
		login.login();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// Click HRMS
		WebElement HRMS = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sideBar']/ul/li[2]/a")));

		HRMS.click();

		// Click Add Employee submenu
		WebElement Addemployeesubmenu = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Add Employee']")));

		Addemployeesubmenu.click();
//======================================= 1 of 4 ===========================================================

		// First Name
		WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("employee.fName")));
		firstname.sendKeys("Cris");

		// Last Name
		WebElement lastname = driver.findElement(By.name("employee.lName"));
		lastname.sendKeys("Ronl");

		// Father Name
		WebElement fathername = driver.findElement(By.name("employee.fatherName"));
		fathername.sendKeys("xxxxx");

		// Gender
		WebElement gender = driver.findElement(By.name("employee.gender"));

		Select sec = new Select(gender);
		sec.selectByVisibleText("Male");

		// Open Date of Birth
		WebElement dob = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='my-form']/div[1]/div[2]/div[5]/div/input[2]")));

		dob.click();

		// Select August
		WebElement month = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("flatpickr-monthDropdown-months")));

		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText("August");

		// Select year
		WebElement year = driver.findElement(By.xpath("//input[@aria-label='Year']"));

		year.clear();
		year.sendKeys("2001");

		// Select day 6
		driver.findElement(By.xpath("//span[contains(@class,'flatpickr-day') and @aria-label='August 6, 2001']"))
				.click();

		// Date of Joining

		// Date of Joining
		WebElement DOJ = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@type='text' and @placeholder='Select joining date']")));

		DOJ.click();

		// Month
		WebElement DOJmonth = wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("div.flatpickr-calendar.open select.flatpickr-monthDropdown-months")));

		Select selectMonth1 = new Select(DOJmonth);
		selectMonth1.selectByVisibleText("September");

		// Year
		WebElement year1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div.flatpickr-calendar.open input.cur-year")));

		year1.click();
		year1.clear();
		year1.sendKeys("2026");

		// Day
		WebElement day = wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("div.flatpickr-calendar.open span.flatpickr-day[aria-label='September 5, 2026']")));

		day.click();

		// email
		WebElement Emails = driver.findElement(By.name("employee.email"));
		Emails.sendKeys("xyz@gmail.com");

		WebElement Mobile = driver.findElement(By.name("employee.mobile"));
		Mobile.sendKeys("8899960053");

		WebElement address = driver.findElement(By.name("employee.address"));
		address.sendKeys("1234 aa ");
		// in time
		WebElement inTime = wait.until(ExpectedConditions.elementToBeClickable(By.id("inTime")));

		inTime.click();

		WebElement hour = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Hour']")));
		hour.clear();
		hour.sendKeys("08");

		// Minute
		WebElement minute = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Minute']")));
		minute.clear();
		minute.sendKeys("45");

		// Second
		WebElement second = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[contains(@class,'flatpickr-second')]")));

		second.clear();
		second.sendKeys("12");

		// out time
		WebElement outTime = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@type='text' and @placeholder='Select Out Time']")));

		outTime.click();

		WebElement hour1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div.flatpickr-calendar.open input.flatpickr-hour")));
		hour1.clear();
		hour1.sendKeys("18");

		WebElement minute1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div.flatpickr-calendar.open input.flatpickr-minute")));
		minute1.clear();
		minute1.sendKeys("30");

		WebElement second1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div.flatpickr-calendar.open input.flatpickr-second")));
		second1.clear();
		second1.sendKeys("01");
		// Department
		WebElement Department = driver.findElement(By.name("employee.department"));
		Select dp = new Select(Department);
		dp.selectByVisibleText("Plant");

		// Designation
		WebElement Designation = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("employee.designation")));

		Select DS = new Select(Designation);
		DS.selectByVisibleText("Manager");

		// Shift
		WebElement Shift = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("employee.shift")));

		Select Shift1 = new Select(Shift);
		Shift1.selectByVisibleText("Day");

		// Report Manager
		WebElement reportingmgr = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("employee.reporting_mgr")));

		Select mgr = new Select(reportingmgr);

		mgr.selectByValue("MG00001");

		// Employee Type
		WebElement empType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("employee.empType")));

		Select Type = new Select(empType);
		Type.selectByVisibleText("Casual");

		// Role
		WebElement roleid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("employee.roleId")));

		Select ID = new Select(roleid);
		ID.selectByVisibleText("Employee");

		// Location
		WebElement location = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("employee.locationId")));

		Select Location = new Select(location);
		Location.selectByVisibleText("Greater Noida");

		// Next
		WebElement Nextbutton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'next')]")));

		Nextbutton.click();
//======================================= 2 of 4 ===========================================================		

		// Martial Status
		WebElement MartialStatus = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("personalDetails.marital_status")));
		Select status = new Select(MartialStatus);
		status.selectByVisibleText("Unmarried");

		// Blood
		WebElement Blood = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("personalDetails.bloodGroup")));
		Select BD = new Select(Blood);
		BD.selectByVisibleText("B+");

		// emergencyContact
		WebElement emergencyContact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ecname")));

		emergencyContact.sendKeys("Rahul");

		
		// Emergency Contact
		WebElement emergencyContactNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ecn")));

		emergencyContactNumber.sendKeys("9876543210");

		// profile
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Profile.jpg";

		WebElement ProfilePhoto = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));

		ProfilePhoto.sendKeys(filePath);

		// Next button

		List<WebElement> nextButtons = driver.findElements(By.cssSelector("button.next"));

		for (WebElement button : nextButtons) {

			if (button.isDisplayed() && button.isEnabled()) {
				button.click();
				break;
			}
		}
//=========================================== 3 of 4==============================================================

		// Aadhar card

		WebElement aadhar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("bankDetail.aadhar")));

		aadhar.sendKeys("123456789012");

		// Next Button
		List<WebElement> nextButtons3 = driver.findElements(By.cssSelector("button.next"));

		for (WebElement button : nextButtons3) {

			if (button.isDisplayed() && button.isEnabled()) {
				button.click();
				break;
			}
		}
//=========================================== 4 of 4 ==============================================================		

		// Address Proof

		String filePath1 = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\address_Proof.pdf";

		WebElement addressProof = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("add_prof")));

		addressProof.sendKeys(filePath1);

		/*
		 * // Submit WebElement Submit = wait.until(ExpectedConditions
		 * .elementToBeClickable(By.
		 * xpath("//button[@type='submit' and contains(@class,'btn-premium-success')]"))
		 * );
		 * 
		 * Submit.click();
		 */

	}

	
	
}