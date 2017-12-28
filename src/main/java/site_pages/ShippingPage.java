package site_pages;

import org.openqa.selenium.WebDriver;

public class ShippingPage extends BasePage{
    public ShippingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PaymentPage proceedCheckout(){
        //verify page
        LOG.info("Accepting terms and proceed to Payment page");
        $("//*[@id=\"cgv\"]").submit();

        $("//*[@id=\"form\"]/p/button/span").click();

        return new PaymentPage(webDriver);
    }
}
