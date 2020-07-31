package uk.bongosway.selenium.config.driver;

import org.openqa.selenium.WebDriver;

public class Driver {

  private Driver() {
  }

  static WebDriver newInstanceOf(DriverProvider driverProvider) {
    return driverProvider.create();
  }
}
