package site_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddressPage extends BasePage{
    public AddressPage(WebDriver webDriver) {
        super(webDriver);
    }
    public ShippingPage proceedToShippingPage(){
        assertThat(ExpectedConditions.titleIs("Order - My Store"));
        LOG.info("Proceed to shipping page");

        $("//*[@id=\"center_column\"]/form/p/button/span").click();

        return new ShippingPage(webDriver);
    }
}
