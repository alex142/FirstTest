package site_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultPage extends BasePage {

    public ResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    Actions action = new Actions(webDriver);
    WebElement mouseover = $("//*[@id=\"center_column\"]/ul/li[1]/div");

    public ResultPage addItem(){
        LOG.info("Adding first item from search");
        action.moveToElement(mouseover).perform();
        assertThat(ExpectedConditions.visibilityOf($("//*[@id='center_column']//span[text()='Add to cart']")));

        action.moveToElement(mouseover).perform();

        $("//*[@id='center_column']//span[text()='Add to cart']").click();
        return new ResultPage(webDriver);
    }

    public CartSummaryPage proceedToChekout(){
        assertThat(ExpectedConditions.visibilityOf($("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")));
        $("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span").click();

        return new CartSummaryPage(webDriver);
    }




}
