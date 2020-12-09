package pageLocatorsAction;

import org.openqa.selenium.WebDriver;

import pageLocators.HomePageLocators;

public class HomePageActions extends HomePageLocators{

	public HomePageActions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickDeposit() {
		depositButton.click();
	}
}
