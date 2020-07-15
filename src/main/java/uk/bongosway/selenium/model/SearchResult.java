package uk.bongosway.selenium.model;

import java.util.Map;

public class SearchResult {

  Map<String, String> result;

  public SearchResult(Map<String, String> result) {
    this.result = result;
  }

  public String linkTextPosition(int index) {
    return result.get(String.valueOf(index - 1));
  }
}
