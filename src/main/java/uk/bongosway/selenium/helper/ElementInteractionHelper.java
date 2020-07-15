package uk.bongosway.selenium.helper;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class ElementInteractionHelper {

  private ElementInteractionHelper() {
  }

  public static void enterText(WebDriver driver, By by, String text){
    driver.findElement(by).sendKeys(text);
  }

  public static void click(WebDriver driver, By by) {
    driver.findElement(by).click();
  }

  public static List<WebElement> getElementList(WebDriver driver, By by) {
    return driver.findElements(by);
  }
}
