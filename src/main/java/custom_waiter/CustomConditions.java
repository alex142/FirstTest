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
                //Debug only
                /*
                for (WebElement item : list) {
                    System.out.println(item.getText());
                }*/
                return list.get(index).getText().equalsIgnoreCase(text) ? list : null;
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
                //System.out.println(pageTitle + ' ' + pageURL);
                return pageTitle.equals(title) && pageURL.equals(url);
            }
        };

    }
    public static ExpectedCondition<Boolean> stalenesOfElement(WebElement element){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                System.out.println("Start");
                return false ? element.isDisplayed() : true;
            }
        };
    }

    public static ExpectedCondition<Boolean> textOfElementEquals(String sampleText, String elementText){
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {

                return sampleText.contains(elementText);
            }
        };

    }
}
