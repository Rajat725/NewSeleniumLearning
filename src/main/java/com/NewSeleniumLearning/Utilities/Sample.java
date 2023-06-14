package com.NewSeleniumLearning.Utilities;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.reporters.IReporterConfig;
import org.testng.xml.XmlSuite;

public class Sample implements IReporter{

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
	}

	@Override
	public IReporterConfig getConfig() {
		// TODO Auto-generated method stub
		return IReporter.super.getConfig();
	}

}
