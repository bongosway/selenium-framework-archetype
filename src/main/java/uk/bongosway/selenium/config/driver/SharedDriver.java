package uk.bongosway.selenium.config.driver;

import org.openqa.selenium.WebDriver;

public class SharedDriver {

  private SharedDriver() {

  }

  public static WebDriver getDriver() {
    return DriverFactory.getDriver();
  }
}
