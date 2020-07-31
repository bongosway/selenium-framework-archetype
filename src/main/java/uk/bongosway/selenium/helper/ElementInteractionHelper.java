package uk.bongosway.selenium.helper;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class ElementInteractionHelper {

  private static WebDriver driver;

  private ElementInteractionHelper() {
  }

  public static void setDriver(WebDriver driver) {
    ElementInteractionHelper.driver = driver;
  }

  public static void enterText(By by, String text) {
    driver.findElement(by).sendKeys(text);
  }

  public static void click(By by) {
    driver.findElement(by).click();
  }

  public static List<WebElement> getElementList(By by) {
    return driver.findElements(by);
  }

  public static boolean isDisplayed(By by) {
    return driver.findElement(by).isDisplayed();
  }
}
