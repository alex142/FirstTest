package surefire;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import site_pages.AccountPage;
import site_pages.BasePage;
import site_pages.LoginPage;

public class MainPage extends BasePage {
    static final String BASE_URL = "http://automationpractice.com/index.php";
    public static final By SEARCH_FIELD_LOCATOR = By.id("search_query_top");
    public static final By ADVICE_LOCATOR = By.xpath("//*[@id='center_column']//h5/a");

    public MainPage(WebDriver webDriver){
        super(webDriver);
    }

    public void visit(){
        open(BASE_URL);
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"facebook_block\"]/div/div/span/iframe")
    WebElement iframe;

    JavascriptExecutor jsExec = (JavascriptExecutor)webDriver;

    public void scrollToFrame()
    {
        jsExec.executeScript("document.getElementById('facebook_block').scrollIntoView()");
    }

    public String getFrameText()
    {
        assertThat(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        String text = $("//*[@id=\"u_0_1\"]/div[2]/div[2]/div[1]/a").getText();
        webDriver.switchTo().defaultContent();
        return text;
    }



    public LoginPage goToLogin()
    {
        $("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a").click();
        return new LoginPage(webDriver);
    }

    public AccountPage goToAccount(){
        $("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span").click();
        return new AccountPage(webDriver);
    }

}
