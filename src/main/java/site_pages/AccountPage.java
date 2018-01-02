package site_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage{
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    private WebElement logoutButton;

    protected LoginPage signOut(){
        logoutButton.click();
        return new LoginPage(webDriver);
    }

    public OrderHistoryPage openOrderHistory(){
        assertThat(ExpectedConditions.elementToBeClickable($("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")));
        $("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span").click();
        assertThat(ExpectedConditions.titleIs("Order history - My Store"));
        return new OrderHistoryPage(webDriver);
    }

    public AccountPage(WebDriver webDriver){
        super(webDriver);
    }
}
