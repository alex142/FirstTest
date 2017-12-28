package site_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "\"//*[@id=\\\"header\\\"]/div[2]/div/div/nav/div[1]/a\"")
    WebElement signInButton;

    public void enterQuery(String query) {
        $(SEARCH_FIELD_LOCATOR).click();
        $(SEARCH_FIELD_LOCATOR).clear();
        $(SEARCH_FIELD_LOCATOR).sendKeys(query);
    }

    public ResultPage searchItem(String query) {
        $(SEARCH_FIELD_LOCATOR).click();
        $(SEARCH_FIELD_LOCATOR).clear();
        $(SEARCH_FIELD_LOCATOR).sendKeys(query);
        $(SEARCH_FIELD_LOCATOR).sendKeys(Keys.ENTER);

        return new ResultPage(webDriver);
    }

    public LoginPage goToLogin()
    {
        $("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a").click();
        return new LoginPage(webDriver);
    }

}
