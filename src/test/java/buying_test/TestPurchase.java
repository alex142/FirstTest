package buying_test;

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

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPurchase extends SimpleAPI{
    static WebDriver webDriver;
    private static final String email = "oleksii.kukharenko142@gmail.com";
    private static final String passwd = "alex142";

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver.exe");
        System.setProperty("log4j2.debug", "C:\\Users\\Oleksii.Kukharenko\\IdeaProjects\\FirstTest\\src\\main\\resources\\log4j2");
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
        String query = "Dress";

        MainPage mainPage = new MainPage(webDriver);
        mainPage.visit();
        mainPage.goToLogin().login(email, passwd);
        mainPage.visit();
        assertThat(ExpectedConditions.titleIs("My Store"));
        mainPage.searchItem(query).addItem().proceedToChekout().proceedToAdrressPage().
                proceedToShippingPage().proceedToPayment().payByBankWire();
        mainPage.goToAccount().openOrderHistory();
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(webDriver);
        assertThat(textOfElementEquals(orderHistoryPage.expandOrders().getItemName(), query));

        //ResultPage resPage = new ResultPage(webDriver).addItem();
        //assertThat(ExpectedConditions.visibilityOf($(By.id("layer_cart"))));

    }
}
