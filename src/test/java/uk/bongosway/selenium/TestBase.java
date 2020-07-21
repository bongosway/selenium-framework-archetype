package uk.bongosway.selenium;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import ru.stqa.selenium.factory.WebDriverPool;
import uk.bongosway.selenium.config.CustomGuiceModule;
import uk.bongosway.selenium.listener.CustomListener;

/**
 * Base class for TestNG-based test classes
 */

@Listeners(CustomListener.class)
@Guice(modules = CustomGuiceModule.class)
public class TestBase {

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverPool.DEFAULT.dismissAll();
  }
}
