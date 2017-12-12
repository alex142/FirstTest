package page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    private WebDriver webDriver;
    @FindBy(id = "email")
    private WebElement emailBox;

    @FindBy(id = "passwd")
    private WebElement passBox;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    private WebElement submitButton;

    public LoginPage enterUserName(String email){
        emailBox.clear();
        emailBox.sendKeys(email);
        return new LoginPage(webDriver);
        //webDriver.findElement(By.id("email")).sendKeys(email);
    }
    public LoginPage enterPassword(String passwd){
        passBox.clear();
        passBox.sendKeys(passwd);
        return new LoginPage(webDriver);
    }
    public void clickSigninBtn(){
        submitButton.click();
    }
    public AccountPage login(String username, String passwd){
        enterUserName(username);
        enterPassword(passwd);
        clickSigninBtn();
        return new AccountPage(webDriver);
    }

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
