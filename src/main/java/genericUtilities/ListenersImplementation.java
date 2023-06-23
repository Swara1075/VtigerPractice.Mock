package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-----Test Execution Started-----");
		test=report.createTest(methodName);
		test.log(Status.INFO, methodName+"->Started");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-----Test Execution Success-----");
		test.log(Status.PASS, methodName+"->Pass");
		
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-----Test Execution Failure-----");
		System.out.println(result.getThrowable());
		test.log(Status.FAIL, methodName+"->Fail");
		test.log(Status.WARNING, methodName+"->warning");
		
		WebDriverUtility wUtil=new WebDriverUtility();
		String screenShotName = methodName+new JavaUtility().getSystemDateInformat();
		
		try {
			String path = wUtil.takeScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-----Test Execution Skipped-----");
		System.out.println(result.getThrowable());
		test.log(Status.SKIP, methodName+"->Skip");
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
             System.out.println("-----Execution Started-----");
             ExtentSparkReporter html=new ExtentSparkReporter(".\\ExtentReports\\Report - "+new JavaUtility().getSystemDateInformat());
             html.config().setDocumentTitle("vtiger Execution Report");
             html.config().setReportName("Build v1.2.3");
             html.config().setTheme(Theme.DARK);
             
             report=new ExtentReports(); 
             report.attachReporter(html);
             report.setSystemInfo("Base Browser", "chrome");
             report.setSystemInfo("Base url", "http://localhost:8888/");
             report.setSystemInfo("Base platform", "windows-family");
             report.setSystemInfo("Reporter", "Swathi");
             
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("-----Execution Finished-----");
		
		report.flush();
		
	}
	
	

}
