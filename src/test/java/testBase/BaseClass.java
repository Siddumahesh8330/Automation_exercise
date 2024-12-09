package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {

	public static WebDriver driver;
	public Properties p;
	public WebDriverWait waits;
	public Logger logger;

	@Parameters({ "os", "browser" })
	@BeforeClass(groups = { "Sanity", "Regression", "Master" })

	public void setUp(String os, String brow) throws Throwable {
		{
			//Loading config.properties file
			FileReader file=new FileReader("./src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
					
			logger=LogManager.getLogger(this.getClass());  //lOG4J2
					
			if(p.getProperty("execution_evn").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities capabilities=new DesiredCapabilities();
				
				//os
				if(os.equalsIgnoreCase("windows"))
				{
					capabilities.setPlatform(Platform.WIN11);
				}
				else if(os.equalsIgnoreCase("linux"))
				{
					capabilities.setPlatform(Platform.LINUX);
					
				}
				else if (os.equalsIgnoreCase("mac"))
				{
					capabilities.setPlatform(Platform.MAC);
				}
				else
				{
					System.out.println("No matching os");
					return;
				}
				
				//browser
				switch(brow.toLowerCase())
				{
				case "chrome": capabilities.setBrowserName("chrome"); break;
				case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
				case "firefox": capabilities.setBrowserName("firefox"); break;
				default: System.out.println("No matching browser"); return;
				}
				
				driver=new RemoteWebDriver(new URL("http://192.168.1.101:4444/wd/hub"),capabilities);
			}
			
					
			if(p.getProperty("execution_evn").equalsIgnoreCase("local"))
			{

				switch(brow.toLowerCase())
				{
				case "chrome" : driver=new ChromeDriver(); break;
				case "edge" : driver=new EdgeDriver(); break;
				case "firefox": driver=new FirefoxDriver(); break;
				default : System.out.println("Invalid browser name.."); return;
				}
			}
			
				driver.get(p.getProperty("url"));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
			
		}
	}

	public WebDriverWait WebDriverWait(WebDriver driver2, Duration ofSeconds) {
		waits = WebDriverWait(driver, Duration.ofSeconds(10));
		return null;
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void tearDown() {
		driver.quit();
	}

	public String randomAlp() {
		String GeneratedAlp = RandomStringUtils.randomAlphabetic(5);
		return GeneratedAlp;

	}

	public String randomNum() {
		String GeneratedNum = RandomStringUtils.randomNumeric(10);
		return GeneratedNum;
	}

	public String randomNumQty() {
		String generatedString = RandomStringUtils.random(1);
		return generatedString;
	}

	public String randomEmail() {
		String generatedStringN = RandomStringUtils.randomAlphabetic(6);
		String generatedstringA = RandomStringUtils.randomNumeric(3);
		return (generatedStringN + generatedstringA + "@gmail.com");
	}

	public String randomPassword() {
		String generatedN = RandomStringUtils.randomAlphabetic(3).toUpperCase();
		String generateda = RandomStringUtils.randomNumeric(3);
		return (generatedN + "!" + generateda);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}
}
