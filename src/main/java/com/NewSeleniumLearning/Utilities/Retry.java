package com.NewSeleniumLearning.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int i=0;
	int maxTry=3;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(i<maxTry)
		{
			i++;
			return true;
		}
		
		return false;
	}

}
