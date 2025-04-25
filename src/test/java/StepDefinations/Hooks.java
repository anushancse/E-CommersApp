package StepDefinations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Hooks {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void openBrowser(Scenario scenario) {
        // Initialize Extent report once
        if (extent == null) {
        	String reportName = "SparkReport_" + java.util.UUID.randomUUID() + ".html";
        	ExtentSparkReporter spark = new ExtentSparkReporter("reports/" + reportName);
            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Project", "Demoblaze Automation");
            extent.setSystemInfo("Tester", "Anusha kavali");
        }

        // Start reporting this scenario
        test = extent.createTest(scenario.getName());

        String browserName = "chrome"; // You can also externalize this
        if (browserName.contains("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.contains("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.contains("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");
        test.info("Launched browser and navigated to Demoblaze.");
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String screenshotName = "screenshots/" + scenario.getName().replaceAll(" ", "_") + "_" + System.currentTimeMillis() + ".png";
        File dest = new File(screenshotName);
        try {
            FileUtils.copyFile(src, dest);
            test.addScreenCaptureFromPath(screenshotName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("Scenario Failed: " + scenario.getName());
        } else {
            test.pass("Scenario Passed");
        }

        if (driver != null) {
            driver.quit();
        }

        extent.flush();
    }
}