package site_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OrderHistoryPage extends BasePage {
    public OrderHistoryPage(WebDriver webDriver) {
        super(webDriver);
    }
    public OrderHistoryPage expandOrders()
    {
        LOG.info("Expand orders");

        assertThat(ExpectedConditions.visibilityOf($("//*[@id=\"order-list\"]/tbody/tr[1]/td[7]/a[1]/span")));
        $("//*[@id=\"order-list\"]/tbody/tr[1]/td[7]/a[1]/span").click();

        return new OrderHistoryPage(webDriver);
    }
    public String getItemName()
    {
        LOG.info("Get name of first purchase");
        return $("//*[@id=\"order-detail-content\"]/table/tbody/tr/td[2]/label").getText();
    }
}
