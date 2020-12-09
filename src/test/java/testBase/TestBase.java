package testBase;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static ChromeOptions options;
	public static JavascriptExecutor je;
	protected String[] FAILURE_SCREENSHOT = new String[5];
	protected int countOfFailure = 0;
	
	protected WebDriverWait wait;
	public void setChromeOptions() {
		WebDriverManager.chromedriver().browserVersion("87.0.4280.88").setup();
		//System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		options = new ChromeOptions();
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation"); 
		options.addArguments("--no-sandbox"); 
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation"); 
	    options.addArguments("--disable-notifications");
		options.addArguments("--window-size=1920,1080");
		 driver = new ChromeDriver(options);
	}
	
}
