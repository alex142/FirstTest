package page_factory;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClass {
    //protected static final String BASE_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    protected static final String BASE_URL = "http://automationpractice.com/index.php";
    public static final By SIGN_IN_BUTTON_LOCATOR = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    private static final String email = "oleksii.kukharenko142@gmail.com";
    private static final String passwd = "alex142";
    protected static WebDriver webDriver;

    @BeforeClass
    public static void setUp(){
        //System.setProperty("webdriver.chrome.driver", "C:\\install\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
        //assertThat(titleIs("My Store"));
        webDriver.findElement(SIGN_IN_BUTTON_LOCATOR).click();
        //assertThat(titleIs("Login - My Store"));
    }

    @AfterClass
    public static void  tearDown(){
        webDriver.quit();
        webDriver = null;
    }
    @Ignore
    @Test
    public void login_1(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(email, passwd);
        assertThat(titleContains("My account - My Store"));

    }
    //@Ignore
    @Test
    public void login_2(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.enterUserName(email).enterPassword(passwd).clickSigninBtn();
        assertThat(titleContains("My account - My Store"));
    }

    @Test
    public void logout(){
        assertThat(titleContains("My account - My Store"));
        AccountPage accountPage =  new AccountPage(webDriver);
        accountPage.signOut();
        assertThat(titleContains("Login - My Store"));
    }

    public static void assertThat(ExpectedCondition<Boolean> condition) {
        (new WebDriverWait(webDriver, 5)).until(condition);
    }


}
