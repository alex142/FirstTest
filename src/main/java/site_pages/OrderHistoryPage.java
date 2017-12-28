package site_pages;

import org.openqa.selenium.WebDriver;

public class OrderHistoryPage extends BasePage {
    public OrderHistoryPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void expandOrders()
    {
        LOG.info("Expand orders");
        $("//*[@id=\"order-list\"]/tbody/tr/td[1]/a").click();
    }
    public String getItemName()
    {
        LOG.info("Get name of first purchase");
        return $("//*[@id=\"order-detail-content\"]/table/tbody/tr/td[2]/label").getText();
    }
}
