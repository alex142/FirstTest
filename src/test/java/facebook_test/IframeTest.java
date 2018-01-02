package facebook_test;


import iframe.CredsHandler;
import iframe.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import site_pages.AccountPage;
import site_pages.MainPage;
import site_pages.OrderHistoryPage;
import site_pages.SimpleAPI;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static custom_waiter.CustomConditions.textOfElementEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IframeTest extends SimpleAPI {

    static WebDriver webDriver;

    private static final Logger LOG = LogManager.getLogger(IframeTest.class);

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver.exe");
        webDriver = new ChromeDriver();

        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        webDriver.quit();
        webDriver = null;
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }

    iframe.MainPage mainPage = new iframe.MainPage(webDriver);

    @Test
    public void test_iframe()
    {
        mainPage.visit();
        assertThat(titleContains("My Store"));
        mainPage.scrollToFrame();
        assertThat(textOfElementEquals(mainPage.getFrameText(), "PrestShop"));

        //loginPage.login(CredsHandler.getProperty("login"),CredsHandler.getProperty("passwd"));
    }
}