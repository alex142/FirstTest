package lesson_6.a_implicitly_wait.d_refactor_waits;

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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.applet.Main;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

@RunWith(JUnit4.class)

public class FirstTest {

    protected static final String BASE_URL = "http://automationpractice.com/index.php";
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setUp(){
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
    public void githubShouldBeOpen(){
        MainPage mainPage = new MainPage();
        mainPage.searchField.sendKeys("dress");
        assertThat(textToBePresentInElementLocated(mainPage.advice,"dress"));
        mainPage.searchField.clear();

        mainPage.searchField.sendKeys("shirt");
        assertThat(textToBePresentInElementLocated(mainPage.advice,"shirt"));

    }

    class MainPage{
        @FindBy(id = "search_query_top")
        private WebElement searchField;

        @FindBy(xpath = "\"//*[@id=\\\"index\\\"]/div[2]/ul/li[1]\"")
        WebElement advice;

        MainPage(){
            PageFactory.initElements(webDriver, this);
        }
    }

    private void assertThat(ExpectedCondition<Boolean> condition) {
        (new WebDriverWait(webDriver, 5)).until(condition);
    }
   /*
    @Test
    public void searchRepository(){
        WebElement inputField = webDriver.findElement(By.name("q"));
        inputField.click();
        inputField.sendKeys("maven");
        inputField.submit();
        WebElement firstResult = webDriver.findElement(By.xpath("//*[@id='js-pjax-container']/div[1]/div/div[1]/ul/div[1]/div[1]/h3/a/em"));
        Assert.assertEquals("maven", firstResult.getText());


    }
    */
}
