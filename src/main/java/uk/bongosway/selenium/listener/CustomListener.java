package uk.bongosway.selenium.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class CustomListener extends TestListenerAdapter implements ITestListener {

  private static final String SKIPPED = "SKIPPED (%8.1f)s: ";
  private static final String FAILURE = "FAILURE (%8.1f)s: ";
  private static final String SUCCESS = "Success (%8.1f)s: ";

  @Override
  public void onTestFailure(ITestResult testResult) {
    super.onTestFailure(testResult);
    log(String.format(FAILURE, duration(testResult)) + formatDescription(testResult));
  }

  @Override
  public void onTestSkipped(ITestResult testResult) {
    log(SKIPPED + formatDescription(testResult));
  }

  @Override
  public void onTestSuccess(ITestResult testResult) {
    super.onTestSuccess(testResult);
    log(String.format(SUCCESS, duration(testResult)) + formatDescription(testResult));

  }

  private void log(String string) {
    Reporter.log("[ " + string + " ]", true);
  }

  private String formatDescription(ITestResult result) {
    return result.getMethod().getDescription();
  }

  private float duration(ITestResult result) {
    return (result.getEndMillis() - result.getStartMillis()) / 1000f;
  }
}
