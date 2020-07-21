package uk.bongosway.selenium.config.driver;

import static uk.bongosway.selenium.helper.UrlHelper.stringToUrl;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverPool;
import uk.bongosway.selenium.config.AppConfiguration;

public class RemoteDriverProvider implements DriverProvider {

  protected static AppConfiguration config = AppConfiguration.getInstance();

  @Override
  public WebDriver create() {
    URL gridHubUrl = config.gridUrl()
                           .equalsIgnoreCase("") ? null : stringToUrl(config.gridUrl());
    return WebDriverPool.DEFAULT.getDriver(gridHubUrl, config.getCapabilities());
  }
}
