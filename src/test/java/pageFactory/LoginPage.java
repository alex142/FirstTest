package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage{

    private WebDriver webDriver;
    @FindBy(id = "email")
    private WebElement emailBox;

    @FindBy(id = "passwd")
    private WebElement passBox;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    private WebElement submitButton;

    public void enterUserName(String email){
        emailBox.clear();
        emailBox.sendKeys(email);
        //webDriver.findElement(By.id("email")).sendKeys(email);
    }
    public void enterPassword(String passwd){
        passBox.clear();
        passBox.sendKeys(passwd);
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

    public LoginPage(WebDriver webDriver){this.webDriver = webDriver;}
}
