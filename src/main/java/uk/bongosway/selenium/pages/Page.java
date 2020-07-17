package uk.bongosway.selenium.pages;

import org.openqa.selenium.WebDriver;
import uk.bongosway.selenium.config.AppConfiguration;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;
  protected final AppConfiguration configuration = AppConfiguration.getInstance();

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
}
