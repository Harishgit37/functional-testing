package com.harish.pom;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.harish.helper.Base;

public class OrdersPage extends Base{

	private WebDriverWait wait;	
	
	@FindBy(xpath = "//span[@class='sidenavHoverShow css-1s178v5']")
	private WebElement orderIcon;
	
	@FindBy(xpath = "(//span[text()='Orders'])[1]")
	private WebElement ordersSubIcon;
	
	@FindBy(xpath = "//button[text()='Add Bulk Orders']")
	private WebElement addBulkOrdersIcon;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileUpload;
	
	@FindBy(xpath = "(//button[@type='button'])[7]")
	private WebElement importButton;
	
	@FindBy(xpath = "(//button[@type='button'])[7]")
	private WebElement validateData;
	
	@FindBy(tagName = "html")
	private WebElement scrollDown;
	
	@FindBy(xpath = "(//button[@type='button'])[7]")
	private WebElement submitButton;
	
	public OrdersPage() {
		
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    PageFactory.initElements(driver, this);
	}

    public void clickOnOrderIcon() {
		
    	
		wait.until(ExpectedConditions.elementToBeClickable(orderIcon)).click();
	}
    
    public void clickOnOrdersIcon() {
		
		wait.until(ExpectedConditions.elementToBeClickable(ordersSubIcon)).click();
	}
    
    public void clickOnAddBulkOrdersIcon() {
		
		wait.until(ExpectedConditions.elementToBeClickable(addBulkOrdersIcon)).click();
	}
    
    public void uploadFile(String fUpl) throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(fileUpload)).sendKeys(fUpl);
		fileUpload.sendKeys("C:\\Users\\keerthana\\Downloads\\demo-data.xlsx");

		if (fileUpload.isDisplayed()) 
			System.out.println("Successfully uploaded");
		else
			System.out.println("Not Uploaded");
	}
    
    public void clickOnImportButton() {
		
		wait.until(ExpectedConditions.elementToBeClickable(importButton)).click();
	}
    
    public void clickOnValidateData() {
		
		wait.until(ExpectedConditions.elementToBeClickable(validateData)).click();
	}

    public void handleUnexpectedAlert() {
    	
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert found with text: " + alertText);
                alert.accept();  // Accept the alert (click 'OK')
                System.out.println("Alert accepted.");

            } catch (NoAlertPresentException e) {
                System.out.println("No alert present.");
            } catch (UnhandledAlertException e) {
                System.out.println("Unhandled alert exception: " + e.getMessage());
            }
     }

    public void scrollDown() throws InterruptedException {
      	 
	    JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("window.scrollBy(0,2000)");
        wait.until(ExpectedConditions.elementToBeClickable(scrollDown)).click();
    }
    
    public void captureScreenshot() throws InvocationTargetException {
        try {
            handleUnexpectedAlert();

            Shutterbug.shootPage(driver, Capture.FULL_SCROLL, true)
                      .save(".//src//test//resources//screenshots//");
            System.out.println("Screenshot captured successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while taking screenshot: " + e.getMessage());
            
            captureScreenshot();
        }
    }

    
    public void clickOnSubmitButton() {
    	
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
}
