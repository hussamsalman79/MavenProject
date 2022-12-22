package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class craterLoginPage {
	
	public craterLoginPage() {
		
		PageFactory.initElements(Driver.getDriver(), this);
	
	}
	
	
	@FindBy(name = "email")
	public WebElement useremail; 
	
	@FindBy(name = "password")
	public WebElement password; 
	
	@FindBy(linkText ="Forgot Password?")
	public WebElement forgotPasswordLink; 


	@FindBy(xpath ="//button[text() ='Login']")
	public WebElement loginButton; 
	
	@FindBy(xpath ="//p[contains(text(), 'Copyright @ Crater Invoice, Inc. 2022')]")
	public WebElement copyRightText; 
	
	
	@FindBy(xpath ="//h1[contains(text(), 'Simple Invoicing for')]")
	public WebElement bussinesSlogan; 
	
	@FindBy(xpath ="//p[contains(text(), 'Crater helps you track expenses')]")
	public WebElement bussinessSubText; 
	
	@FindBy(xpath ="//p[contains(text(), 'These credentials do not match our records.')]")
	public WebElement invalidUserErrorMessage; 
	
	

}
