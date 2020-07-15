package uk.bongosway.selenium.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uk.bongosway.selenium.component.SearchForm;
import uk.bongosway.selenium.model.SearchResult;
import uk.bongosway.selenium.pages.HomePage;

public class SearchEngine {

  private final WebDriver driver;
  private Map<String, String> searchResults = new HashMap<>();


  public SearchEngine(final WebDriver driver) {
    this.driver = driver;
  }

  public SearchResult searchFor(final String term) {
    AtomicInteger index = new AtomicInteger();
    List<WebElement> results = new HomePage(driver).search(term).collectResults();

    searchResults = results.stream()
                           .filter(e -> !e.getText().equals(""))
                           .limit(4)
                           .collect(Collectors.toMap(
                               p -> String.valueOf(index.getAndIncrement()), WebElement::getText)
                           );

    return new SearchResult(searchResults);
  }
}
