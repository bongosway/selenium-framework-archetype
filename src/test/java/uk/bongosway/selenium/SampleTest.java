package uk.bongosway.selenium;

import static org.testng.Assert.assertEquals;

import com.google.inject.Inject;
import java.util.List;
import org.testng.annotations.Test;
import uk.bongosway.selenium.model.SearchResult;
import uk.bongosway.selenium.model.SearchEngine;

public class SampleTest extends TestBase {

  @Inject
  SearchEngine searchEngine;

  @Test(description = "Selenium Link should be No. 1 on Google Search")
  public void orgNameIs_1st_ForSearchTerm_Selenium() {

    List<SearchResult> results = searchEngine.searchFor("Selenium");
    assertEquals(
        results.get(0).getLinkText(),
        "The Selenium Browser Automation Project :: Documentation ..."
    );
  }
}
