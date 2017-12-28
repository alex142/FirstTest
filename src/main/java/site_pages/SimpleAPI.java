package site_pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class SimpleAPI {
    public abstract WebDriver getWebDriver();

    protected WebElement $(By locator){
        return assertThat(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement $(String xpath){
        return $(By.xpath(xpath));
    }

    List<WebElement> $$(By locator){
        return assertThat(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    List<WebElement> $$(String xpath){
        return getWebDriver().findElements(By.xpath(xpath));
    }

    protected void open(String url){
        getWebDriver().get(url);
    }
    protected  <V> V assertThat(Function<? super WebDriver, V> condition) {
        return (new WebDriverWait(getWebDriver(),5)).until(condition);
    }
}
