package uk.bongosway.selenium.model;

public class SearchResult {
  private String link;
  private String linkText;
  private String linkCitation;
  private String summary;

  public SearchResult(String link, String linkText, String linkCitation, String summary) {
    this.link = link;
    this.linkText = linkText;
    this.linkCitation = linkCitation;
    this.summary = summary;
  }

  public String getLink() {
    return link;
  }

  public String getLinkText() {
    return linkText;
  }

  public String getLinkCitation() {
    return linkCitation;
  }

  public String getSummary() {
    return summary;
  }

  @Override
  public String toString() {
    return "SearchResult{" +
        "link='" + link + '\'' +
        ", linkText='" + linkText + '\'' +
        ", linkCitation='" + linkCitation + '\'' +
        ", summary='" + summary + '\'' +
        '}';
  }
}
