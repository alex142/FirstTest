package iframe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import site_pages.AccountPage;

public class LoginPage extends BasePage {

    static final String LOGIN_URL = "http://automationpractice.com/index.php";

    private WebDriver webDriver;
    @FindBy(id = "email")
    private WebElement emailBox;

    @FindBy(id = "passwd")
    private WebElement passBox;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    private WebElement submitButton;

    public void visit(){
        open(LOGIN_URL);
    }

    public void login(String username, String passwd){
        emailBox.clear();
        emailBox.sendKeys(username);

        passBox.clear();
        passBox.sendKeys(passwd);

        submitButton.click();

    }

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }
}
