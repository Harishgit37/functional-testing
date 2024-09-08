package com.harish.testcase;

import org.openqa.selenium.support.PageFactory;


import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.harish.helper.Base;
import com.harish.pom.OrdersPage;
import com.harish.utilities.ScreenRecorderUtil;
import com.harish.utilities.Utility;


public class OrdersFunctionalTest extends Base {
  @Test
  public void ordersTest() throws Exception {
	  
	  ScreenRecorderUtil.startRecord("ordersTest");
	  
	  Utility utility = new Utility();
	  utility.loginPage("prexo.mis@dealsdray.com", "prexo.mis@dealsdray.com");
	  
	  OrdersPage ordersPage = PageFactory.initElements(driver, OrdersPage.class);
	  
	  ordersPage.clickOnOrderIcon();
	  
	  ordersPage.clickOnOrdersIcon();
	  
	  ordersPage.clickOnAddBulkOrdersIcon();
	  
	  ordersPage.uploadFile("C:\\Users\\keerthana\\Downloads\\demo-data.xlsx");
	  
	  ordersPage.clickOnImportButton();
	  
	  ordersPage.clickOnValidateData();
	  
      ordersPage.handleUnexpectedAlert();
	  
      ordersPage.scrollDown();
      
      ordersPage.captureScreenshot();

	  ordersPage.clickOnSubmitButton();  
	  
	  ScreenRecorderUtil.stopRecord();
  }
}
