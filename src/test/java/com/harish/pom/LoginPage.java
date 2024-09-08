package com.harish.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.harish.helper.Base;

public class LoginPage extends Base{


	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passWord;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public void clickOnLoginButton() {
		
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}
}
