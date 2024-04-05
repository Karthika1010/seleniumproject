package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import POM.PomAddProducts;
import waitutility.WaitUtility;
import webDriverUtility.BrowserUtility;
import extentreports.ExtentTestManager;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;


public class AddProducts extends ExtentTestManager {
	
	 public static WebDriver driver; 
	 PomAddProducts objproduct;
	 WaitUtility wait;
  @Test(groups= {"functional"},priority=10,description="user is able to add products",enabled=true)
  public void addProduct() throws InterruptedException, IOException {
	  BrowserUtility objutil = new BrowserUtility();
	  driver = objutil.baseDriver();
	  wait = new WaitUtility(driver);
	  wait.Normalwait(6000); 
	  objproduct=new PomAddProducts(driver);
	  objproduct.productMenuClick();
	  objproduct.addproductName("parker Pen");
	  wait.Normalwait(6000);	  
	  objproduct.selectBrand();
	  wait.Normalwait(3000);	  
	  objproduct.selectUnit();
	  wait.Normalwait(4000);	  
	  objproduct.selectBarcodeType();
	  wait.Normalwait(3000);	 
	  objproduct.addselectAlertQty("20");
	  wait.Normalwait(3000);
	  objproduct.addpurchaseIncTax("4");
	  wait.Normalwait(6000);
	  objproduct.addexpiry("15");
	  objproduct.productSaveBtnClick();
	  test.log(Status.PASS, "Test validate Add products");
	 
	  //objutil.Screenshot();
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
