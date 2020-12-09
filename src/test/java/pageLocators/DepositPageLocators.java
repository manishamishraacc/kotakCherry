package pageLocators;

import org.openqa.selenium.WebDriver;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class DepositPageLocators extends TestBase {
	protected WebDriver driver;

	@FindBy(xpath = "//h2[text()='Fixed deposit']")
	protected WebElement fixedDeposit;

	@FindBy(xpath = "//div[@class='ieco-blue-underline']")
	//span[@class='ng-star-inserted']
	protected WebElement amountText;

	@FindBy(xpath="//div[@class='ieco-blue-underline']//input[@name='investedAmt']")
	protected WebElement amountvalue;
	
	@FindBy(xpath = "//button[@color='primary']")
	protected WebElement proceedButton;
	
	@FindBy(xpath = "//div[text()='Minimum: 10000']")
	protected WebElement miniumErrorMessage;
	
	@FindBy(xpath = "//div[text()='Maximum: 100000']")
	protected WebElement maxErrorMessage;
	
	@FindBy(xpath="//div[@class='ieco-bd-pad-16 ieco-desk-padlr-0 ieco-td']//div[@class='ng-star-inserted']//div[@class='col s12']")
	protected WebElement tenure;
	
	@FindBy(name="dipositDurationYear")
	protected WebElement yearText ;
	
	@FindBy(name="dipositDurationMonth")
	protected WebElement monthText ;
	
	@FindBy(name="dipositDurationDay")
	protected WebElement daysText ;
	
	@FindBy(xpath="//button[@color='primary']//span[text()=' Done ']")
	protected WebElement tenureDone ;

	public DepositPageLocators(WebDriver driver) {
		this.driver = driver;
		// Initializing the Page Objects:
		PageFactory.initElements(driver, this);
	}
}
