package com.NewSeleniumLearning.Base;



import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.w3c.dom.DOMConfiguration;

import com.NewSeleniumLearning.PageObjects.LoginPage;
import com.NewSeleniumLearning.Utilities.Constants;
import com.NewSeleniumLearning.Utilities.PageManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	public LoginPage lp;
	public PageManager pm;


	public WebDriver initialization() throws IOException {
		String path = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\NewSeleniumLearning\\Utilities\\GlobalProperty.properties";
		FileInputStream fis = new FileInputStream(path);
		 prop = new Properties();
	
		prop.load(fis);
		
		//String browserName = prop.getProperty("browser");
		
		String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions op = new ChromeOptions();

			op.addArguments("--remote-allow-origins=*");
			 driver = new ChromeDriver(op);
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();

		} else {
			System.out.println("Browser not FOund ");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitTimeOut"))));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pagLoadTimeOut"))));
		driver.manage().window().maximize();
		//driver.get(prop.getProperty("url"));
		driver.get(Constants.URL);
		pm=new PageManager(driver);
		return driver;
		

	}
	
	
	public String getScreenShot(String testCaseName,WebDriver driver) throws IOException
	{
		
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src=tk.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"//Screenshots//"+testCaseName+".png";
		File scr=new File(path);
		FileUtils.copyFile(src, scr);
		return path;
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage setUp() throws IOException
	{
		driver=initialization();
	    driver.manage().deleteAllCookies();
	   // lp=new LoginPage(driver);
	    lp=pm.getloginPage();
	    return lp;
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
