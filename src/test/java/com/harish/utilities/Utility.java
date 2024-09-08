package com.harish.utilities;


import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.harish.helper.Base;
import com.harish.pom.LoginPage;

public class Utility extends Base{

public void loginPage(String username , String password) {
		
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.getUserName().sendKeys(username);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		loginPage.getPassWord().sendKeys(password);
		
		loginPage.clickOnLoginButton();
	}

    @DataProvider(name = "userData")
    public Object[][] userData(){
	  
       return new Object[][] {	  
		
	     new Object[] { "prexo.mis@dealsdray.com" ,"prexo.mis@dealsdray.com"},
	 
	   }; 
  }
}



