package custom_waiter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nullable;
import java.util.List;



public class CustomConditions {

    public static ExpectedCondition<List<WebElement>> listNthElementHasText(By locator, int index, String text){
        return new ExpectedCondition<List<WebElement>>() {
            @Nullable
            @Override
            public List<WebElement> apply(@Nullable WebDriver webDriver) throws IndexOutOfBoundsException {
                List<WebElement> list = webDriver.findElements(locator);
                return list.get(index).getText().equals(text) ? list : null;
            }
        };
    }
    public static ExpectedCondition<Boolean> pageIsLoaded(String title, String url){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                String pageTitle = webDriver.getTitle();
                String pageURL = webDriver.getCurrentUrl();
                return pageTitle.contains(title) && pageURL.contains(url);
            }
        };

    }
    public static ExpectedCondition<Boolean> stalenesOfElement(WebElement element){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                return !element.isDisplayed();
            }
        };
    }
}
