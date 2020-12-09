package pageLocatorsAction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageLocators.DepositPageLocators;

public class Deposit extends DepositPageLocators {
	public void clickFixedDeposit() {
	fixedDeposit.click();
	}
	public void clearAmount() {
		amountText.clear();
	}
	public void enterAmount(String amount) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		System.out.println("before clear text of amount");
		
		js.executeScript("arguments[0].click();", amountText);
		 js.executeScript("arguments[0].value ='';", amountvalue);
		 System.out.println("2");
		  js.executeScript("arguments[0].value='"+amount+"';", amountvalue);
		
	
		/*
		 * new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(
		 * amountText)); amountText.clear(); amountText.sendKeys(amount);
		 */
	}
	public void clickProceed() {
	proceedButton.click();
	}
	public void validateMin_AmountMessage() {
		if(miniumErrorMessage.isDisplayed() == true) {
			System.out.println(miniumErrorMessage.getText());
		}
	}
	public void validateMax_AmountMessage() {
		if(maxErrorMessage.isDisplayed() == true) {
			System.out.println(maxErrorMessage.getText());
		}
	}
	public void enterTenure(String year,String month, String days) {
		tenure.click();
		yearText.clear();
		yearText.sendKeys(year);
		monthText.clear();
		monthText.sendKeys(month);
		daysText.clear();
		daysText.sendKeys(days);
	}
	public void tenureDone() {
		tenureDone.click();
	}
	public Deposit(WebDriver driver) {
		super(driver);
	}
}
