package site_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShippingPage extends BasePage{
    public ShippingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PaymentPage proceedToPayment(){
        assertThat(ExpectedConditions.titleIs("Order - My Store"));
        LOG.info("Accepting terms and proceed to Payment page");
        $("//*[@id=\"cgv\"]").click();
        assertThat(ExpectedConditions.elementToBeSelected($("//*[@id=\"cgv\"]")));

        $("//*[@id=\"form\"]/p/button/span").click();

        return new PaymentPage(webDriver);
    }
}
