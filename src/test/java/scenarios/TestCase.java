package scenarios;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageLocatorsAction.Deposit;
import pageLocatorsAction.HomePageActions;
import testBase.TestBase;

public class TestCase extends TestBase {
	int brokenImageCount = 0;

	@DataProvider(name = "depositValue")
	public static Object[][] primeNumbers() {
		return new Object[][] { { "10000", "0", "12", "25" } };
	}

	@BeforeTest
	public void setUp() {
		setChromeOptions();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://kotakcherry.com/home");
	}

	@Test(dataProvider = "depositValue")
	public void testCase(String amount, String yearValue, String monthValue, String dayValue) throws ClientProtocolException, IOException, InterruptedException {
		HomePageActions homePageAction = new HomePageActions(driver);
		Deposit depositAction = new Deposit(driver);
		homePageAction.clickDeposit();
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		// find broken image count
		for (WebElement imgElement : imagesList) {
			if (imgElement != null) {
				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(imgElement.getAttribute("src"));
				HttpResponse response = client.execute(request);
				// verifying response code he HttpStatus should be 200 if not,
				// increment as invalid images count
				if (response.getStatusLine().getStatusCode() != 200)
					brokenImageCount++;
			}
		}
		System.out.println("Total no. of broken images are " + brokenImageCount);
        
		depositAction.clickFixedDeposit();
		Thread.sleep(4000);
		depositAction.enterAmount("0");
		Thread.sleep(3000);
		depositAction.clickProceed();
		depositAction.validateMin_AmountMessage();
		driver.navigate().refresh();
		depositAction.enterAmount("100001");
		Thread.sleep(3000);
		depositAction.clickProceed();
		depositAction.validateMax_AmountMessage();
		driver.navigate().refresh();
		depositAction.enterAmount(amount);
		Thread.sleep(2000);
		depositAction.enterTenure(yearValue, monthValue, dayValue);
		depositAction.tenureDone();
	}
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result){
	//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		if(ITestResult.FAILURE==result.getStatus()){
			try{
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				// Call method to capture screenshot
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location 
				// result.getName() will return name of test case so that screenshot name will be same as test case name
				Random rand = new Random();
				FAILURE_SCREENSHOT[countOfFailure] = "test-output/failure_screenshot/"+result.getName() + "_" + (1000  + rand.nextInt(9000)) +".png";
				FileUtils.copyFile(src, new File(FAILURE_SCREENSHOT[countOfFailure]));
				countOfFailure++;
				System.out.println("TEST CASE FAILED -> Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
		
		driver.quit();
		}
}
