package uk.bongosway.selenium.helper;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlHelper {

  private UrlHelper() {
  }

  /**
   * . produce a fully resolved uri See {@link URI#resolve(String)} returns a string
   */
  public static String resolve(String url, String path) {
    try {
      return new URI(ensureTrailingSlash(url)).resolve(path).toString();
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException(
          String.format("Cannot resolve {%s} and {%s}", url, path), e);
    }
  }

  /**
   * Constructs a new Url with the specified string
   * The String must have the required nomenclature, else
   * a malformed exception will be thrown
   *
   * @param value must contain the protocol and hostname
   * @exception IllegalArgumentException
   */
  public static URL stringToUrl(String value) {
    try {
      return new URL(value);
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException(
          String.format("%s is malformed due to %s", value, e));
    }
  }

  private static String ensureTrailingSlash(String url) {
    return url.endsWith("/") ? url : url + "/";
  }
}