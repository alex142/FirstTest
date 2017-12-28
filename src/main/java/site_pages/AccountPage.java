package site_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage{
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    private WebElement logoutButton;

    protected LoginPage signOut(){
        logoutButton.click();
        return new LoginPage(webDriver);
    }

    public AccountPage(WebDriver webDriver){
        super(webDriver);
    }
}
