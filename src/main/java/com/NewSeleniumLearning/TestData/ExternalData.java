package com.NewSeleniumLearning.TestData;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExternalData {

	@DataProvider(name = "data1")
	public Object[][] getData1() {

		Map<String, String> mp = new HashMap<String, String>();
		mp.put("username", "ExternalTestData1");
		mp.put("password", "ExternalTestData1");

		Map<String, String> mp2 = new HashMap<String, String>();
		mp2.put("username", "ExternalTestData2");
		mp2.put("password", "ExternalTestData2");

		Map<String, String> mp3 = new HashMap<String, String>();
		mp3.put("username", "ExternalTestData3");
		mp3.put("password", "ExternalTestData3");

		return new Object[][] {

				{ mp }, { mp2 }, { mp3 } };

	}

}
