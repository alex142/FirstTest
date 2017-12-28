package buying_test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import site_pages.MainPage;
import site_pages.ResultPage;
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

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPurchase extends SimpleAPI{
    static WebDriver webDriver;
    private static final String email = "oleksii.kukharenko142@gmail.com";
    private static final String passwd = "alex142";

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver.exe");
        webDriver = new ChromeDriver();

        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    @Test
    public void test1()
    {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.visit();
        mainPage.goToLogin().login(email, passwd);
        mainPage.visit();
        assertThat(ExpectedConditions.titleIs("My Store"));
        mainPage.searchItem("Dress");
        ResultPage resPage = new ResultPage(webDriver).addItem();
        //assertThat(ExpectedConditions.visibilityOf($(By.id("layer_cart"))));

    }
}
