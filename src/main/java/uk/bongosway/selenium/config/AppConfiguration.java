package uk.bongosway.selenium.config;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Loads test suite configuration from resource files.
 */
public class AppConfiguration {

  private static final String DEBUG_PROPERTIES = "/debug.properties";
  private static AppConfiguration instance = new AppConfiguration();
  private Properties properties = new Properties();

  private AppConfiguration() {
    this(System.getProperty("application.properties", DEBUG_PROPERTIES));
  }

  private AppConfiguration(String fromResource) {
    try {
      properties.load(AppConfiguration.class.getResourceAsStream(fromResource));
    } catch (IOException e) {
      throw new IllegalStateException("Could not load Application Properties!", e);
    }
  }

  public static AppConfiguration getInstance() {
    return instance;
  }

  public Capabilities getCapabilities() {
    String capabilitiesFile = getProperty("capabilities");

    Properties capsProps = new Properties();
    try {
      capsProps.load(AppConfiguration.class.getResourceAsStream(capabilitiesFile));
    } catch (IOException e) {
      throw new IllegalStateException("Could not load Capabilities Properties!", e);
    }

    DesiredCapabilities capabilities = new DesiredCapabilities();
    for (String name : capsProps.stringPropertyNames()) {
      String value = capsProps.getProperty(name);
      if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
        capabilities.setCapability(name, Boolean.valueOf(value));
      } else {
        capabilities.setCapability(name, value);
      }
    }

    return capabilities;
  }

  public String baseUrl() {
    return getProperty("site.url");
  }

  public String gridUrl() {
    return getProperty("grid.url");
  }

  private boolean hasProperty(String name) {
    return properties.containsKey(name);
  }

  public String getProperty(String name) {
    if (!hasProperty(name)){
      throw new IllegalStateException(
          String.format("{%s} property not present!", name));
    }

    return properties.getProperty(name);
  }
}
