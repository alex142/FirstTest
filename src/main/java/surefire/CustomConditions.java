package surefire;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import javax.annotation.Nullable;
import java.util.List;


public class CustomConditions {

    public static ExpectedCondition<List<WebElement>> listNthElementHasText(By locator, int index, String text){
        return new ExpectedCondition<List<WebElement>>() {
            @Nullable
            @Override
            public List<WebElement> apply(@Nullable WebDriver webDriver){
                List<WebElement> list = webDriver.findElements(locator);
                //Debug only
                /*
                for (WebElement item : list) {
                    System.out.println(item.getText());
                }*/
                String textOfElement = "";
                try {
                    textOfElement =  list.get(index).getText();
                }
                catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();

                }
                //System.out.println(textOfElement);
                return textOfElement.equalsIgnoreCase(text) ? list : null;
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
                return element.isDisplayed() ? false : true;
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
