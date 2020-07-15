package uk.bongosway.selenium.component;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    WebDriverWait wait = new WebDriverWait(driver, 10, 100);
    wait.until(d -> d.findElement(searchFormAutocomplete).isDisplayed());

    ElementInteractionHelper.click(driver, searchFormAutocomplete);
    return this;
  }

  public List<WebElement> collectResults() {
    return ElementInteractionHelper.getElementList(driver, resultsLinkText);
  }
}
