package test;

import com.aventstack.extentreports.service.ExtentTestManager;
import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test Name: " + result.getName() + "is Started " + "On Env: " + DriverManager.getInfo());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test Name: " + result.getName() + "is  Passed ");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failTest(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.error(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // empty
    }

    @Override
    public void onStart(ITestContext context) {
        // empty
    }

    @Override
    public void onFinish(ITestContext context) {
        // empty
    }

    private void failTest(ITestResult iTestResult) {
        log.error(iTestResult.getTestClass().getName());
        log.error(iTestResult.getThrowable());

        String screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().addScreenCaptureFromBase64String(screenshot);
    }

}
