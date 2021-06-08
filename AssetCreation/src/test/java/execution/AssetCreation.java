package execution;

import org.testng.annotations.Test;

import pageObject.AssetMainPage;
import pageObject.FTAssetMainPage;
import pageObject.LogInPage;

import functions.TestBase;

import org.testng.annotations.BeforeTest;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class AssetCreation extends TestBase{
	LogInPage Login ;
	AssetMainPage AssetMainPage;
	FTAssetMainPage FTAssetMainPage;
	@Test 
	public void assetCreation() throws Exception {
		LaunchandLogin();
		Login = PageFactory.initElements(driver, LogInPage.class);
		Login.login();
		// login();
		waitForLoad();
		AssetMainPage = PageFactory.initElements(driver, AssetMainPage.class);
		FTAssetMainPage=  PageFactory.initElements(driver, FTAssetMainPage.class);
		if(SystemType.equalsIgnoreCase("RL")) {
			DeleteSheets("RL");
			createDataSheet_RemovePrevious("RL");
		}else {
			DeleteSheets("FT");
			createDataSheet_RemovePrevious("FT");
		}
		for(nextNumber=1;nextNumber<executerows;nextNumber++) {
			Result.clear();
			try {
				if(SystemType.equalsIgnoreCase("RL")) {
					AssetMainPage.createAsset();
				}else {

					FTAssetMainPage.CreateProject(nextNumber);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writeResult(SystemType);
		}
	}



	@BeforeTest
	public void beforeTest() throws Exception, IOException {
		System.out.println("Execution started");
		readOneExcel("FTProjectInputData");
		executerows=rowCount;
		readConfigValues();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Execution End");
	}

}
