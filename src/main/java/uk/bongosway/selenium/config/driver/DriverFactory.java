package uk.bongosway.selenium.config.driver;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import uk.bongosway.selenium.config.AppConfiguration;

public class DriverFactory {

  private static final ThreadLocal<WebDriver> DRIVERS = new ThreadLocal<>();
  private static List<WebDriver> driverPool = new ArrayList<>();
  private static DriverProvider driverProvider;

  static {
    Runtime.getRuntime().addShutdownHook(
        new Thread(() -> driverPool.forEach(WebDriver::quit)));

    unloadDrivers();
  }

  private DriverFactory() {
  }

  public static WebDriver getDriver() {
    if (DRIVERS.get() == null) {
      WebDriver driver = Driver.newInstanceOf(getProvider());
      addDriverToPool(driver);
    }
    return driverProvider.create();
  }

  private static void addDriverToPool(WebDriver driver) {
    driverPool.add(driver);
    DRIVERS.set(driver);
  }

  public static void unloadDrivers() {
    DRIVERS.remove();
  }

  private static DriverProvider getProvider() {
    if (AppConfiguration.getInstance().getProperty("env").equalsIgnoreCase("local")) {
      driverProvider = new LocalDriverProvider();
    } else {
      driverProvider = new RemoteDriverProvider();
    }

    return driverProvider;
  }
}
