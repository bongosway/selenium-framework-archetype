package uk.bongosway.selenium.model;

import java.util.List;
import org.openqa.selenium.WebDriver;
import uk.bongosway.selenium.pages.HomePage;

public class SearchEngine {
  private final WebDriver driver;

  public SearchEngine(final WebDriver driver) {
    this.driver = driver;
  }

  public List<SearchResult> searchFor(final String term)  {
    return new HomePage(driver).search(term).collectResults();
  }
}
