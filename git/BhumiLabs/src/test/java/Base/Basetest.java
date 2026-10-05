package Base;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Basetest {
	public static Properties pro = new Properties();
	public static Properties loc = new Properties();
	public static WebDriver driver;
	public static FileReader fr;
	public static FileReader fr1;

	@BeforeMethod
	public void setup() throws IOException {
		if (driver == null) {
			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Congfigfiles\\config.properties");
			FileReader fr1 = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Congfigfiles\\Locator.properties");
			pro.load(fr);
			loc.load(fr1);
		}

		if (pro.getProperty("brower").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();

			Map<String, Object> prefs = new HashMap<>();

			// Disable Chrome password manager popup
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);

			// Disable password leak detection popup
			prefs.put("profile.password_manager_leak_detection", false);

			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(pro.getProperty("URL")); // Properties

		}

		else if (pro.getProperty("brower").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(pro.getProperty("URL")); // Properties
		}
	}

	/*
	 * @AfterMethod public void teardown() {
	 * 
	 * driver.close(); System.out.println("System is teardown");
	 * 
	 * }
	 */

}
