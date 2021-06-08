package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import functions.TestBase;

public class LogInPage extends TestBase{

	WebDriver driver;

	public LogInPage(WebDriver driver)
	{
		this.driver=driver;

	}

	@FindBy(id = "userNameInput")
	private WebElement userNameField;

	@FindBy(id = "passwordInput")
	private WebElement passwordField;

	@FindBy(id = "submitButton")
	private WebElement submitButton;
	
	
	@FindBy(id = "Username")
	private WebElement FTuserNameField;

	@FindBy(id = "Password")
	private WebElement FTpasswordField;

	@FindBy(id = "loginButton")
	private WebElement FTsubmitButton;
	
	


	public void login() {
		readOneExcel("LogIn");
		PageFactory.initElements(driver, this);
		int readlogin=1;
		
		if(SystemType.equalsIgnoreCase("FT")) {
			readlogin=2;
			enterText(FTuserNameField,getDatafromJson("FTUserName"));
			enterText(FTpasswordField, getDatafromJson("FTPassword"));
			clickonButton(FTsubmitButton);
		}else {
			enterText(FTuserNameField,getDatafromJson("RLUserName"));
			enterText(FTpasswordField, getDatafromJson("RLPassword"));
			clickonButton(submitButton);
		}
		
	}

}
