package uk.bongosway.selenium.config.driver;

import org.openqa.selenium.WebDriver;

public interface DriverProvider {
    WebDriver create();
}
