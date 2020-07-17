package uk.bongosway.selenium;

import static uk.bongosway.selenium.helper.UrlHelper.stringToUrl;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import ru.stqa.selenium.factory.WebDriverPool;
import uk.bongosway.selenium.config.AppConfiguration;
import uk.bongosway.selenium.listener.CustomListener;

/**
 * Base class for TestNG-based test classes
 */

@Listeners(CustomListener.class)
public class TestBase {

  protected static AppConfiguration config = AppConfiguration.getInstance();

  protected WebDriver driver;

  @BeforeMethod
  public void initWebDriver() {
    URL gridHubUrl = config.gridUrl()
                           .equalsIgnoreCase("") ? null : stringToUrl(config.gridUrl());
    driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, config.getCapabilities());
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverPool.DEFAULT.dismissAll();
  }
}
