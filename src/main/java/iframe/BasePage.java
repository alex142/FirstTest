package iframe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends SimpleAPI {

    protected WebDriver webDriver;

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }

    protected final Logger LOG = LogManager.getLogger(this);

    public BasePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
