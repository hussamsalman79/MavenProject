package tests;

import org.testng.annotations.Test;

import pages.caterDashboardPage;
import pages.craterLoginPage;
import utils.Driver;
import utils.TestDataReader;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class craterUserManagement {
  @Test
  public void validLogin() {
	  
	  Driver.getDriver().get(TestDataReader.getProperty("craterUrl"));
	  craterLoginPage loginPage = new craterLoginPage(); 
	  
	  WebDriverWait wait = new WebDriverWait (Driver.getDriver(),5); 
	  
	  
	  
	  loginPage.useremail.sendKeys(TestDataReader.getProperty("craterValidPassword"));
	  loginPage.password.sendKeys(TestDataReader.getProperty("craterValidPassword"));
	  loginPage.loginButton.click();
	  
	  
	  // Verify the amount due element display
	  caterDashboardPage dashboardPage = new caterDashboardPage(); 
	  Assert.assertTrue(dashboardPage.amountDueText.isDisplayed()); 
	  
	  
	  // Verify the url contains dashboard
	 String dashboardUrl =  Driver.getDriver().getCurrentUrl();
	 Assert.assertTrue(dashboardUrl.contains("dashboard"));
	 
  }
  
  @BeforeMethod
  public void setUp() {
	  
	 Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
	 
	  
	  
  }

  @AfterMethod
  public void tearDown() {
	  
	  Driver.quitDriver();
	  
  }

}
