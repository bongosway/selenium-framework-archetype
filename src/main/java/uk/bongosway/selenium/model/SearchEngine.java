package uk.bongosway.selenium.model;

import java.util.List;

public interface SearchEngine {
  List<SearchResult> searchFor(final String term);
}
