package uk.bongosway.selenium.component;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uk.bongosway.selenium.helper.ElementInteractionHelper;

public class SearchForm {

  private final WebDriver driver;
  private static final By searchFormAutocomplete = By.cssSelector("#searchform ul>li");
  private static final By inputField = By.name("q");
  private static final By resultsLinkText = By.cssSelector("#search .g .r a>h3");


  public SearchForm(WebDriver driver) {
    this.driver = driver;
  }

  public SearchForm enterTerm(String term) {
    ElementInteractionHelper.enterText(driver, inputField, term);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    ElementInteractionHelper.click(driver, searchFormAutocomplete);
    return this;
  }

  public List<WebElement> collectResults() {
    return ElementInteractionHelper.getElementList(driver, resultsLinkText);
  }
}
