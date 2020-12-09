package pageLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePageLocators extends TestBase{
	WebDriver driver;
	@FindBy(xpath="//div[text()=' Deposits ']")
	protected WebElement depositButton;

	//Constructor
		public HomePageLocators(WebDriver driver) {
			this.driver = driver;
			//Initializing the Page Objects:
			PageFactory.initElements(driver, this);
		}

}
