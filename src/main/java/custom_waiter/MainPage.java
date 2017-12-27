package custom_waiter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    static final String BASE_URL = "http://automationpractice.com/index.php";
    public static final By SEARCH_FIELD_LOCATOR = By.id("search_query_top");
    public static final By ADVICE_LOCATOR = By.xpath("//*[@id='center_column']//h5/a");

    public MainPage(WebDriver webDriver){
        super(webDriver);
    }
    public void visit(){
        open(BASE_URL);
    }
    public void enterQuery(String query) {
        $(SEARCH_FIELD_LOCATOR).click();
        $(SEARCH_FIELD_LOCATOR).clear();
        $(SEARCH_FIELD_LOCATOR).sendKeys(query);
    }
}
