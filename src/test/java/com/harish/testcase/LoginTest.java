package com.harish.testcase;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.harish.helper.Base;
import com.harish.pom.LoginPage;
import com.harish.utilities.Utility;

public class LoginTest extends Base{
  @Test
  public void login() {
	  
      LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
      
      Utility utility = new Utility();
      utility.loginPage("prexo.mis@dealsdray.com", "prexo.mis@dealsdray.com");
  }
}
