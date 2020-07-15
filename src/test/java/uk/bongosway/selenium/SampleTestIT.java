package uk.bongosway.selenium;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import uk.bongosway.selenium.model.SearchEngine;
import uk.bongosway.selenium.model.SearchResult;

public class SampleTestIT extends TestBase {

  private SearchEngine searchEngine;

  @Test
  public void orgNameIs_2nd_ForSearchTerm_Selenium() {
    searchEngine = new SearchEngine(driver);
    driver.get(baseUrl);
    SearchResult result = searchEngine.searchFor("Selenium");

    assertEquals(
        result.linkTextPosition(2), "The Selenium Browser Automation Project :: Documentation ..."
    );
  }
}
