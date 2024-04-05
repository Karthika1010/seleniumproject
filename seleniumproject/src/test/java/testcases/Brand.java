package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.PomBrandSearch;
import POM.PomBrands;
import commonUtility.ConfigFileReader;
import extentreports.ExtentTestManager;
import waitutility.WaitUtility;
import webDriverUtility.BrowserUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Brand extends ExtentTestManager {
	
	 public static WebDriver driver; 
	 PomBrands objBrand;
	 PomBrandSearch objsearch;
	 ConfigFileReader objconfigreader;
	 WaitUtility wait;
  @Test(groups= {"functional"},priority=4,enabled=true)
  
  public void brandadd() throws InterruptedException, IOException {
	  BrowserUtility objutil = new BrowserUtility();
	  driver = objutil.baseDriver();
	  wait = new WaitUtility(driver);
	  wait.Normalwait(2000);
	  objBrand = new PomBrands(driver);
	   objBrand.brand(); 
	  objBrand.brandNameSendKeys("Waterman pen");
	  objBrand.brandDescriptionSendKeys(" Waterman was originally founded by Lewis Waterman in 1884 in New York..");
	  wait.Normalwait(2000);
	  objBrand.brandSave();
	  test.log(Status.PASS, "Test validate Add Brand");
	  wait.Normalwait(2000);
  }
	  @Test(groups={"functional"},priority=5,description = "Verify whether user is able to search with brand name",enabled=true)
	  public void brandsearch() throws InterruptedException, IOException {
		  objsearch=new PomBrandSearch(driver);
		  objconfigreader=new ConfigFileReader();
		  wait = new WaitUtility(driver);
	  String searchValue =ConfigFileReader.readConfigFile("searchValue");
	  wait.Normalwait(2000);
	  objsearch.search(searchValue);
	  wait.Normalwait(2000);
		String data = objsearch.getBrandTablevalue();
		wait.Normalwait(2000);
		Assert.assertEquals(searchValue, data);
		test.log(Status.PASS, "Test validate brandsearch");

	 
  }
	  }
	 


	  
  

