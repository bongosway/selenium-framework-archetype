package uk.bongosway.selenium.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.bongosway.selenium.config.AppConfiguration;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected final AppConfiguration configuration = AppConfiguration.getInstance();
  protected WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   *
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  protected WebElement waitFor(By locator, int timeOut) {
    return new WebDriverWait(driver, timeOut)
        .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  protected WebElement waitFor(By locator) {
    return new WebDriverWait(driver, 5)
        .until(ExpectedConditions.presenceOfElementLocated(locator));
  }
}
