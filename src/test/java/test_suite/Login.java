package test_suite;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
//import sun.applet.Main;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

@RunWith(JUnit4.class)

public class Login {
    protected static final String BASE_URL = "http://automationpractice.com/index.php";
    private static final String email = "oleksii.kukharenko142@gmail.com";
    private static final String passwd = "alex142";
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Install\\chromedriver.exe");
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
    @Before
    public void goHome(){
        webDriver.get(BASE_URL);
    }

    @After
    public void logOut(){
        webDriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
    }

    @Test
    public void loginTo(){
        Login.MainPage mainPage = new Login.MainPage(webDriver);
        mainPage.login(email, passwd);
        assertThat(urlToBe("http://automationpractice.com/index.php?controller=my-account"));
        assertThat(textToBePresentInElementLocated(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"), "Oleksii Kukharenko"));
    }
    @Test
    public void orderHistoryIsAccessible(){
        Login.MainPage mainPage = new Login.MainPage(webDriver);
        mainPage.login(email, passwd);
        mainPage.goToPage(mainPage.ORDERS_BUTTON_LOCATOR);
        Assert.assertTrue( "Check Title",webDriver.getTitle().contains("Order history - My Store"));
    }
    @Test
    public void creditSlipsIsAccessible(){
        Login.MainPage mainPage = new Login.MainPage(webDriver);
        mainPage.login(email, passwd);
        mainPage.goToPage(mainPage.CREDIT_BUTTON_LOCATOR);
        Assert.assertTrue( "Check Title",webDriver.getTitle().contains("Order slip - My Store"));
    }
    @Test
    public void adressInfoIsAccessible(){
        Login.MainPage mainPage = new Login.MainPage(webDriver);
        mainPage.login(email, passwd);
        mainPage.goToPage(mainPage.ADRESS_BUTTON_LOCATOR);
        Assert.assertTrue( "Check Title",webDriver.getTitle().contains("Addresses - My Store"));
    }
    @Test
    public void personalInfoIsAccessible(){
        Login.MainPage mainPage = new Login.MainPage(webDriver);
        mainPage.login(email, passwd);
        mainPage.goToPage(mainPage.PERSONAL_INFO_BUTTON_LOCATOR);
        Assert.assertTrue( "Check Title",webDriver.getTitle().contains("Identity - My Store"));
    }
    @Test
    public void wishlistIsAccessible(){
        Login.MainPage mainPage = new Login.MainPage(webDriver);
        mainPage.login(email, passwd);
        mainPage.goToPage(mainPage.WISHLIST_BUTTON_LOCATOR);
        Assert.assertTrue( "Check Title",webDriver.getTitle().equals("My Store"));
    }

    class MainPage{

        public final By SIGN_IN_BUTTON_LOCATOR = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
        public final By EMAIL_BOX_LOCATOR = By.id("email");
        public final By PASSWORD_BOX_LOCATOR = By.id("passwd");
        public final By SUBMIT_BUTTON_LOCATOR = By.xpath("//*[@id=\"SubmitLogin\"]/span");
        public final By ORDERS_BUTTON_LOCATOR = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span");
        public final By CREDIT_BUTTON_LOCATOR = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a/span");
        public final By ADRESS_BUTTON_LOCATOR = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span");
        public final By PERSONAL_INFO_BUTTON_LOCATOR = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span");
        public final By WISHLIST_BUTTON_LOCATOR = By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span");


        private WebDriver webDriver;

        public MainPage(WebDriver webDriver){
            this.webDriver = webDriver;
        }

        void login(String email, String passwd){
            webDriver.findElement(SIGN_IN_BUTTON_LOCATOR).click();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver.findElement(EMAIL_BOX_LOCATOR).sendKeys(email);
            webDriver.findElement(PASSWORD_BOX_LOCATOR).sendKeys(passwd);
            webDriver.findElement(SUBMIT_BUTTON_LOCATOR).click();
        }

        void goToPage(By locator){
            webDriver.findElement(locator).click();
        }

    }

    private void assertThat(ExpectedCondition<Boolean> condition) {
        (new WebDriverWait(webDriver, 5)).until(condition);
    }
}
