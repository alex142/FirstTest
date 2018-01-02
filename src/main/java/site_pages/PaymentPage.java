package site_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends BasePage{
    public PaymentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void payByBankWire(){
        assertThat(ExpectedConditions.elementToBeClickable($("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a/span")));
        LOG.info("Select BANK-WIRE payment");
        $("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a/span").click();

        assertThat(ExpectedConditions.visibilityOf($("//*[@id=\"cart_navigation\"]/button/span")));
        LOG.info("Confirm order");
        $("//*[@id=\"cart_navigation\"]/button/span").click();
    }

}
