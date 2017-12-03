package testSuite;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

@RunWith(JUnit4.class)

public class SearchTest {

    protected static final String BASE_URL = "http://automationpractice.com/index.php";
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
    }

    @AfterClass
    public static void  testDown(){
        webDriver.quit();
        webDriver = null;
    }

    @Test
    public void checkSearchResult(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.doSearch("Printed Summer Dress");
        List<WebElement> search_results = mainPage.webDriver.findElements(By.xpath("//div[@id=\"center_column\"]/ul/*"));
        Assert.assertEquals(3, search_results.size());
        Assert.assertEquals(mainPage.webDriver.findElement(mainPage.FIRST_SEARCH_LOCATOR).getText(),"Printed Summer Dress");
        }

static class MainPage{

        public final By SEARCH_FIELD_LOCATOR = By.id("search_query_top");
        public final By FIRST_SEARCH_LOCATOR = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a");
        public final By SEARCH_BUTTON_LOCATOR = By.xpath("//*[@id=\"searchbox\"]/button");


        private WebDriver webDriver;

        public MainPage(WebDriver webDriver){
            this.webDriver = webDriver;
        }

        void doSearch(String search_str){
            webDriver.findElement(SEARCH_FIELD_LOCATOR).clear();
            webDriver.findElement(SEARCH_FIELD_LOCATOR).sendKeys(search_str);
            webDriver.findElement(SEARCH_BUTTON_LOCATOR).click();
        }

    }

    private void assertThat(ExpectedCondition<Boolean> condition) {
        (new WebDriverWait(webDriver, 5)).until(condition);
    }

}
