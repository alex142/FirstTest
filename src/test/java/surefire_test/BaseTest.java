package surefire_test;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import surefire.SimpleAPI;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest extends SimpleAPI {

    private static final Logger LOG = LogManager.getLogger(BaseTest.class);
    static WebDriver webDriver;

    @Rule
    public TestRule rule = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            captureScreenshot(description.getMethodName());
        }

    };

    private void captureScreenshot(String methodName) {
        File screenshot = ((TakesScreenshot)webDriver)
                .getScreenshotAs(OutputType.FILE);
        //set path
        if (System.getProperty("report.path") == null) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy-h_mm_ss");
            String formattedDate = dateFormat.format(date);
            System.setProperty("report.path", "./reports/" + methodName + "_" + formattedDate);
        }

        String path = System.getProperty("report.path") + "/screenshots/" + screenshot.getName();
        try {
            FileUtils.copyFile(screenshot, new File(path));
            LOG.info("Screenshot was got: " + screenshot.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        webDriver.quit();
        webDriver = null;
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }


}
