package uk.bongosway.selenium.model;

import com.google.inject.Inject;
import java.util.List;
import org.openqa.selenium.WebDriver;
import uk.bongosway.selenium.config.driver.DriverProvider;
import uk.bongosway.selenium.pages.HomePage;

public class GoogleSearchEngine implements SearchEngine {

  private final WebDriver driver;

  @Inject
  public GoogleSearchEngine(DriverProvider driver) {
    this.driver = driver.create();
  }

  @Override
  public List<SearchResult> searchFor(String term) {
    return new HomePage(driver).search(term).collectResults();
  }
}
