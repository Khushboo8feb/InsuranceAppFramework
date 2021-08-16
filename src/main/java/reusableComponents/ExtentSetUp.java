package reusableComponents;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.ObjectRepo;

public class ExtentSetUp extends ObjectRepo{
	
	public static ExtentReports extentReportSetUp()
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		//get Current date
		Date date = new Date();
		String actualdate = format.format(date);
		
		String reportPath = System.getProperty("user.dir")+
				"/Reports/ExecutionReport_"+actualdate+".html";
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("DocumentTitle");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("ReportName");
		
		return extent;
	}

}
