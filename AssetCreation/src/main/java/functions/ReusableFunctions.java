package functions;

import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableFunctions extends ReadexcelFile{

	public static String path = null;	
	public static JSONObject jsonObject;

	//Function for Print the steps in allure report


	//	@Step("{0}")
	//	public static void logStepWithScreenshot(String stepName ){
	//		attachScreen(stepName);
	//	}
	//
	//	public static void selectBydropDown(WebElement ele, String value) {
	//		ele.click();
	//		Select paymentoption= new Select (ele);
	//		paymentoption.selectByVisibleText(value);
	//	}
	//	//Function for take the screen shot in allure report
	//	@Attachment("Screenshot")
	//	public static byte[] attachScreen(String Exception) {
	//		//logStep(Exception);
	//		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	//	}

	//enter Text in TextBox
	public void enterText(WebElement Ele,String Value) {
		try {
			waitForVisible(Ele);
			Ele.clear();
			Ele.sendKeys(Value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	//enter Text in TextBox
	public void clickonButton(WebElement Ele) {
		try {
			//waitForVisible(Ele);
			waitForlongVisible(Ele);
			waitForClickable(Ele);
			Ele.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	//Mouse hover
	public static void mouseHover(WebDriver driver, WebElement we) {
		Actions action = new Actions(driver);
		action.moveToElement(we).build().perform();
	}


	public static void Scroll(String scrollType) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(scrollType.equalsIgnoreCase("down")) {
			js.executeScript("window.scrollBy(0,1000)");
		}else  if(scrollType.equalsIgnoreCase("up")){
			js.executeScript("window.scrollBy(500,0)");
		}

	}



	//Wait for Page load check
	public static void waitForLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(pageLoadCondition);
	}

	//Scroll to Web Element
	public static void scrolltoElement(WebElement Elenent) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Elenent);

	}
	//Function for provide wait for loader image
	public static void waitforloadingDisable(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("theImg")));
	}

	public static void waitforloadingDisableinsuredDetailsPg(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("Img1")));
	}


	public static void waitforloadingDisableTW(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 600);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("theImg")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("typing_loader")));
	}	

	public static void waitforloadingDisablePaymentPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 750);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("theImg")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
	}	

	//Wait functions
	public static WebElement waitTillElementVisible(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = wait.until(ExpectedConditions.visibilityOf(element));
		return elementloaded;
	}

	//Wait functions
	public static WebElement waitTilliFrameVisible(WebElement FrameName) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameName));
		return elementloaded;
	}


	public static WebElement waitTillElementTobeLocated(By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return elementloaded;
	}

	public static boolean waitTillElementToBeClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		}catch(Exception e) {


			return false;
		}
	}
	public static  boolean waitForVisible(WebElement locator) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(locator));
			return true;
		}catch(Exception e) {
			return false;
		}

	}

	public static  boolean waitForlongVisible(WebElement locator) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) locator));
			return true;
		}catch(Exception e) {
			return false;
		}

	}

	public static  boolean waitForClickable(WebElement locator) throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		}catch(Exception e) {
			return false;
		}

	}

	public static void waitForVisibleDropdown(List<WebElement> elements) throws Exception {
		Thread.sleep(1000);
		for (int i = 0; i <= 25; i++) {
			try {
				if (elements.size() != 0) {
					break;
				} else {
					throw new Exception("list size is 0");
				}

			} catch (Exception e) {
				if (i == 25) {
					throw e;

				} else {
					Thread.sleep(1000);

				}
			}

		}
	}

	//Wait for Page Load
	public static void waitTillPageLoaded(WebDriver driver)  {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Click functionality by Java Script
	public static void clickByJS(WebElement el, WebDriver driver) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", el);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	//Move to Element Function 
	public static void moveToElement(WebElement element, WebDriver driver) {
		try{
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}
		catch(Exception e){
			e.getMessage();
		}
	}

	// Point To Element
	public static void pointToElement(WebElement e1, WebDriver driver){
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", e1);
	}

	// Function for provide wait for VerifyPage Title
	public static void verifypageTitle(String str, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(str));
	}

	//Read Values from Input Json
	public static void readConfigValues() {
		JSONParser parser = new JSONParser();
		String PathJson = ResultPath+"config.json";
		System.out.println("PathJson : "+PathJson);
		try {
			Object obj = parser.parse(new FileReader(PathJson));
			jsonObject = (JSONObject)obj;
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static String getDatafromJson(String Value) {
		String inputValue = null;
		//get Values from Json File
		inputValue = (String)jsonObject.get(Value); // get Values form Json file based on input Value
		System.out.println("Value from Input file :: "+Value+"-----"+inputValue);
		System.out.println("==============================");
		return inputValue;

	}
}
