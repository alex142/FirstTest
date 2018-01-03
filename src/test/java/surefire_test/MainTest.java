package surefire_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import surefire.MainPage;

import static surefire.CustomConditions.listNthElementHasText;
import static surefire.MainPage.ADVICE_LOCATOR;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainTest extends BaseTest {

    private static final Logger LOG = LogManager.getLogger(MainTest.class);
    MainPage mainPage = new MainPage(webDriver);

    @Test
    public void test1_success()
    {
        mainPage.visit();
        mainPage.enterQuery("Dress");
        assertThat(listNthElementHasText(ADVICE_LOCATOR,0, "Faded Short Sleeve T-shirts"));
    }

    @Test
    public void test1_fail()
    {
        mainPage.visit();
        mainPage.enterQuery("Dress");
        assertThat(listNthElementHasText(ADVICE_LOCATOR,0, "Blouse"));
    }
}
