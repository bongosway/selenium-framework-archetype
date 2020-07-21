package uk.bongosway.selenium.config;

import com.google.inject.Binder;
import com.google.inject.Module;
import uk.bongosway.selenium.config.driver.DriverProvider;
import uk.bongosway.selenium.config.driver.RemoteDriverProvider;
import uk.bongosway.selenium.model.GoogleSearchEngine;
import uk.bongosway.selenium.model.SearchEngine;

public class CustomGuiceModule implements Module {

  @Override
  public void configure(Binder binder) {
    binder.bind(SearchEngine.class).to(GoogleSearchEngine.class);
    binder.bind(DriverProvider.class).to(RemoteDriverProvider.class);
  }
}
