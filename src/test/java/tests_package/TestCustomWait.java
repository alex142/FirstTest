package tests_package;

import custom_waiter.MainPage;
import custom_waiter.SimpleAPI;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static custom_waiter.CustomConditions.listNthElementHasText;
import static custom_waiter.CustomConditions.pageIsLoaded;
import static custom_waiter.CustomConditions.stalenesOfElement;
import static custom_waiter.MainPage.ADVICE_LOCATOR;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestCustomWait extends SimpleAPI{
    static WebDriver webDriver;

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

    @Test
    public void test1(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.visit();
        assertThat(ExpectedConditions.titleContains("My Store"));
        mainPage.enterQuery("Dress");
        assertThat(listNthElementHasText(ADVICE_LOCATOR,1, "Blouse"));
    }

    @Test
    public void test2(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.visit();
        WebElement element = $(By.id("searchbox"));
        System.out.println(element.getText());
        $("//*[@id=\"htmlcontent_top\"]/ul/li[2]/a/img").click();
        assertThat(stalenesOfElement(element));
    }
    @Test
    public void test3(){
        webDriver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
        assertThat(pageIsLoaded("Women - My Store", "http://automationpractice.com/index.php?id_category=3&controller=category"));

    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
