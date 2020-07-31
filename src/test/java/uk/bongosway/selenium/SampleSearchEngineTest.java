package uk.bongosway.selenium;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import uk.bongosway.selenium.model.GoogleSearchEngine;
import uk.bongosway.selenium.model.SearchEngine;
import uk.bongosway.selenium.model.SearchResult;

public class SampleSearchEngineTest extends TestBase {
  private SearchEngine searchEngine;

  @Test(description = "Selenium Link should be No. 1 on Google Search")
  public void Is_name_first_in_results_for_searchTerm_Selenium() {
    searchEngine = new GoogleSearchEngine();

    SearchResult result = searchEngine.searchFor("Selenium Java")
                                      .get(0);
    assertEquals(
        result.getLinkText(),
        "The Selenium Browser Automation Project :: Documentation ..."
    );
  }

  @Ignore
  @Test(description = "Take Screenshot on Failure")
  public void takeScreenShotOnFailure() {
    searchEngine = new GoogleSearchEngine();

    SearchResult results = searchEngine.searchFor("Selenium").get(1);
    assertEquals(results.getLinkText(), "Documentation ...");
  }
}
