package uk.bongosway.selenium;

import static org.testng.Assert.assertEquals;

import java.util.List;
import org.testng.annotations.Test;
import uk.bongosway.selenium.model.SearchEngine;
import uk.bongosway.selenium.model.SearchResult;

public class SampleTest extends TestBase {

  @Test(description = "Selenium Link should be No. 2 on Google Search")
  public void orgNameIs_2nd_ForSearchTerm_Selenium() {
    SearchEngine searchEngine = new SearchEngine(driver);

    List<SearchResult> results = searchEngine.searchFor("Selenium");
    assertEquals(
        results.get(1).getLinkText(),
        "The Selenium Browser Automation Project :: Documentation ..."
    );
  }
}
