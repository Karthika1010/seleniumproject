package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import POM.PomCategories;
import POM.PomCategorySearch;
import POM.PomUnitSearch;
import POM.PomUnits;
import commonUtility.ConfigFileReader;
import extentreports.ExtentTestManager;
import waitutility.WaitUtility;
import webDriverUtility.BrowserUtility;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Category extends ExtentTestManager {
	
	public static WebDriver driver; 
	 PomCategories objCategory;
	 PomCategorySearch objcatsearch;
	 ConfigFileReader objconfigreader;	
	 WaitUtility wait;
  @Test(groups= {"functional"},priority=6,description="Verify user is able to save category",enabled=true)
  
  public void categoryadd()throws InterruptedException, IOException {
	  BrowserUtility objutil = new BrowserUtility();
	  driver = objutil.baseDriver();
	  wait = new WaitUtility(driver);
	  wait.Normalwait(2000);
	   objCategory = new PomCategories(driver);
	   objCategory.category();
	   wait.Normalwait(4000);
	   objCategory.categorynameSendKeys("Soft Toys");
	   wait.Normalwait(3000);
	   objCategory.categorycodeSendKeys("SF123");
	   wait.Normalwait(2000);
		  objCategory.categorySave();
		  test.log(Status.PASS, "Test validate  Add category");
		  wait.Normalwait(4000);
  }
		  @Test(groups= {"functional"},priority=7,description="Verify user is able to search with category name",enabled=true)
		  public void categorysearch() throws InterruptedException, IOException
		  {
			  objcatsearch=new PomCategorySearch(driver);
			  wait = new WaitUtility(driver);
			  objconfigreader=new ConfigFileReader();
		  String searchValue1 =ConfigFileReader.readConfigFile("searchValue1");
		  objcatsearch.search(searchValue1);
		  wait.Normalwait(5000);
			String data =  objcatsearch.getcategoryTablevalue();
			wait.Normalwait(6000);
			Assert.assertEquals(searchValue1, data);
			test.log(Status.PASS, "Test validate category search");
	  }
	   
  } 
	  
	  
 

