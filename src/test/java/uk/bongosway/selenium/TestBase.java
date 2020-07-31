package uk.bongosway.selenium;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import uk.bongosway.selenium.config.AppConfiguration;
import uk.bongosway.selenium.config.driver.SharedDriver;
import uk.bongosway.selenium.helper.ElementInteractionHelper;
import uk.bongosway.selenium.helper.ScreenshotHelper;
import uk.bongosway.selenium.listener.CustomListener;

/**
 * Base class for TestNG-based test classes
 */

@Listeners(CustomListener.class)
public class TestBase {

  private WebDriver driver;
  private AppConfiguration appConfiguration = AppConfiguration.getInstance();

  @BeforeMethod
  public void setup() {
    driver = SharedDriver.getDriver();
    ElementInteractionHelper.setDriver(driver);
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result) throws Exception {
    if (!result.isSuccess() && appConfiguration.isErrorScreenshotEnabled()) {
      ScreenshotHelper.takeScreenShot(driver, generateFileName(result), appConfiguration.screenshotLocation());
    }
  }

  private String generateFileName(ITestResult result) {
    var description = result.getMethod().getDescription();

    if (!description.isEmpty()) {
      return description.toLowerCase()
                        .replaceAll(" ", "_") + "-"
           + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + ".png";
    } else {
      return result.getName() + "-"
          + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + ".png";
    }
  }
}
