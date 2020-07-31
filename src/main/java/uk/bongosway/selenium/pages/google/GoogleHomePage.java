package uk.bongosway.selenium.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uk.bongosway.selenium.helper.UrlHelper;
import uk.bongosway.selenium.pages.Page;

/**
 * Sample page
 */
public class GoogleHomePage extends Page {

  private static final String PATH = "/";
  private final By logo = By.id("#hplogo");
  private final SearchForm searchForm;

  public GoogleHomePage(WebDriver webDriver) {
    super(webDriver);
    open();
    searchForm = new SearchForm(driver);
  }

  private void open() {
    driver.get(UrlHelper.resolve(configuration.baseUrl(), PATH));
  }

  public SearchForm search(String term) {
    return searchForm.search(term);
  }
}
