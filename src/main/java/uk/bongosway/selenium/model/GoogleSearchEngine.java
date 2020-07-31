package uk.bongosway.selenium.model;

import java.util.List;
import org.openqa.selenium.WebDriver;
import uk.bongosway.selenium.config.driver.SharedDriver;
import uk.bongosway.selenium.pages.google.GoogleHomePage;

public class GoogleSearchEngine implements SearchEngine {

  private final WebDriver driver;

  public GoogleSearchEngine() {
    this.driver = SharedDriver.getDriver();
  }

  @Override
  public List<SearchResult> searchFor(String term) {
    return new GoogleHomePage(driver).search(term)
                                     .collectResults();
  }
}
