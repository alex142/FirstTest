package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    private WebElement logoutButton;

    protected LoginPage signOut(){
        logoutButton.click();
        return new LoginPage(webDriver);
    }

    public AccountPage(WebDriver webDriver){this.webDriver = webDriver;}
}
