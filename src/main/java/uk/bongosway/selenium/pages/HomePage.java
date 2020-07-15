package uk.bongosway.selenium.pages;

import org.openqa.selenium.WebDriver;
import uk.bongosway.selenium.component.SearchForm;

/**
 * Sample page
 */
public class HomePage extends Page {

  private SearchForm searchForm;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
    searchForm = new SearchForm(driver);
  }

  public SearchForm search(String term) {
    return searchForm.enterTerm(term);
  }
}
