package com.NewSeleniumLearning.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporters {

	public static ExtentReports getReports() {

		String path = System.getProperty("user.dir") + "\\Reports\\result.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Web Automation Result");
		reporter.config().setReportName("Rajat Automation Result");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rajat QA");
		return extent;

	}

}
