package uk.bongosway.selenium.component;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import uk.bongosway.selenium.helper.ElementInteractionHelper;
import uk.bongosway.selenium.model.SearchResult;

public class SearchForm {
  private static final By searchFormAutocomplete = By.cssSelector("#searchform ul>li");
  private static final By inputField = By.name("q");
  private static final By results = By.cssSelector("#search .rc");
  private static final By link = By.cssSelector(".r a");
  private static final By linkText = By.cssSelector(".r a>h3");
  private static final By cite = By.cssSelector(".r a cite");
  private static final By summary = By.cssSelector(".s .st");

  private final WebDriver driver;

  public SearchForm(WebDriver driver) {
    this.driver = driver;
  }

  public SearchForm search(String term) {
    ElementInteractionHelper.enterText(driver, inputField, term);

    WebDriverWait wait = new WebDriverWait(driver, 10, 100);
    wait.until(d -> d.findElement(searchFormAutocomplete).isDisplayed());

    ElementInteractionHelper.click(driver, searchFormAutocomplete);
    return this;
  }

  public List<SearchResult> collectResults() {
    List<WebElement> elementList = ElementInteractionHelper.getElementList(driver, results);
    return elementList.stream()
                      .filter(e -> !e.findElement(linkText).getText().equals(""))
                      .limit(4)
                      .map(e -> new SearchResult(
                          e.findElement(link).getAttribute("href"),
                          e.findElement(linkText).getText(),
                          e.findElement(cite).getText(),
                          e.findElement(summary).getText()))
                      .collect(Collectors.toList());
  }
}
