package site_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultPage extends BasePage {

    public ResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ResultPage addItem(){
        LOG.info("Adding first item from search");
        assertThat(ExpectedConditions.visibilityOf($("//*[@id='center_column']//span[text()='Add to cart']")));

        $("//*[@id='center_column']//span[text()='Add to cart']").click();
        return new ResultPage(webDriver);
    }

    public CartSummaryPage proceedToChekout(){
        $("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span").click();

        return new CartSummaryPage(webDriver);
    }




}
