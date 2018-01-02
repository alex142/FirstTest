package site_pages;

import org.openqa.selenium.WebDriver;

public class CartSummaryPage extends BasePage {
    public CartSummaryPage(WebDriver webDriver) {
        super(webDriver);
    }
    public String getItemDesc(){
        return $("//*[@id=\"product_5_19_0_40162\"]/td[2]/p/a").getText();
    }

    public AddressPage proceedToAdrressPage()
    {
        LOG.info("Proceed to Address page");
        $("//*[@id=\"center_column\"]/p[2]/a[1]/span").click();
        return new AddressPage(webDriver);
    }
}
