package uk.bongosway.selenium.config.driver;

import static uk.bongosway.selenium.helper.UrlHelper.stringToUrl;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverPool;
import uk.bongosway.selenium.config.AppConfiguration;

public class RemoteDriverProvider implements DriverProvider {

  protected static AppConfiguration config = AppConfiguration.getInstance();
  private WebDriver driver;

  @Override
  public WebDriver create() {
    if (driver != null) {
      return driver;
    }

    URL gridHubUrl = config.gridUrl()
                           .equalsIgnoreCase("") ? null : stringToUrl(config.gridUrl());
    driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, config.getCapabilities());
    return driver;
  }
}
