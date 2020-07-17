package uk.bongosway.selenium.pages;

import org.openqa.selenium.WebDriver;
import uk.bongosway.selenium.component.SearchForm;
import uk.bongosway.selenium.helper.UrlHelper;

/**
 * Sample page
 */
public class HomePage extends Page {

  private static final String PATH = "/";
  private final SearchForm searchForm;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
    searchForm = new SearchForm(driver);
  }

  private void open() {
    driver.get(UrlHelper.resolve(configuration.baseUrl(), PATH));
  }

  public SearchForm search(String term) {
    open();
    return searchForm.search(term);
  }
}
