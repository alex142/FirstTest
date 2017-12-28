package site_pages;

import org.openqa.selenium.WebDriver;

public class AddressPage extends BasePage{
    public AddressPage(WebDriver webDriver) {
        super(webDriver);
    }
    public ShippingPage proceedCheckout(){
        //verify page
        LOG.info("Proceed to shipping page");

        $("//*[@id=\"center_column\"]/form/p/button/span").click();

        return new ShippingPage(webDriver);
    }
}
