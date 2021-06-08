package pageObject;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import functions.TestBase;


public class FTAssetMainPage extends TestBase{
	WebDriver driver;
	public static String ProjectType;
	public static String TiteleName;
	public static int SeasonCount;
	public static int EpisodeCount;

	public static ArrayList<String> SeasonsList=new ArrayList<String>();
	public static ArrayList<String> EpisodeNames=new ArrayList<String>();

	public static String AssetSource_Network;
	public static String AssetSource_Acquired;
	public static String AssetSource_Licensed;
	public static String AssetSource_Scripted;

	public FTAssetMainPage(WebDriver driver)
	{
		this.driver=driver;

	}

	//Select options from top AddNew Option
	@FindBy(xpath = "(//*[contains (@class , 'btn btn-primary')])[1]")
	private WebElement AddNewOption;

	@FindBy(xpath = "//*[@class='ft-header-menu ng-star-inserted']/li[1]")
	private WebElement AddContract;

	@FindBy(xpath = "//*[@class='ft-header-menu ng-star-inserted']/li[2]")
	private WebElement AddParty;

	@FindBy(xpath = "//*[@class='ft-header-menu ng-star-inserted']/li[3]")
	private WebElement AddProject;




	//Select Options from Left side pannel
	@FindBy(xpath = "//*[@class='ft-sidebar']//ul/li[@aria-describedby='cdk-describedby-message-0']")
	private WebElement MyFilmTrackButton;

	@FindBy(xpath = "//*[@class='ft-sidebar']//ul/li[@aria-describedby='cdk-describedby-message-1']")
	private WebElement ProjectsButton;

	@FindBy(xpath = "//*[@class='ft-sidebar']//ul/li[@aria-describedby='cdk-describedby-message-2']")
	private WebElement ContractsButton;

	@FindBy(xpath = "//*[@class='ft-sidebar']//ul/li[@aria-describedby='cdk-describedby-message-3']")
	private WebElement PartiesButton;

	@FindBy(xpath = "//*[contains (@class , 'mat-flat-button')]/span[text() = ' Add Project ']")
	private WebElement AddProjectButton;

	@FindBy(xpath = "//*[contains (@class , 'mat-flat-button')]/span[text() = ' Add Contract ']")
	private WebElement AddContractButton;

	@FindBy(xpath = "/html/body/app-root/ng-component/mat-sidenav-container/mat-sidenav-content/div/ft-party-search/div/button")
	private WebElement AddPartiesButton;


	//select Project Type from the list
	@FindBy(xpath = "//*[contains (@class , 'mat-select-value ng-tns')]//span[text() ='Project Type']")
	private WebElement ProjectTypeOption;
	//SelectOption from the list 
	//*[@id='cdk-overlay-15']//span[contains (text() , 'Demo')]


	@FindBy(xpath = "//*[contains (@id ,'mat-input-') and @data-placeholder='Title']")
	private WebElement EnterTitle;

	@FindBy(xpath = "//*[contains (@id ,'mat-input-') and @data-placeholder='Title Code']")
	private WebElement EnterTitleCode;

	@FindBy(xpath = "//*[@aria-label='Genres']")
	private WebElement SelectGenre;

	//Select Genre 
	//span[contains (text() , 'Amusement/Entertainment')]

	@FindBy(xpath = "//*[contains (@id ,'mat-input-') and @data-placeholder='Running Time']")
	private WebElement RunTime;

	@FindBy(xpath = "//input[@placeholder='Keywords']")
	private WebElement KeyWords;


	//Save Project Button
	@FindBy(xpath = "//*[@class='mat-dialog-actions']//button[2]")
	private WebElement SaveButton;

	//Close Project Button
	@FindBy(xpath = "//*[@class=\"mat-dialog-actions\"]//button[1]")
	private WebElement CloseButton;


	//Genral Details of Project

	//Created Project Title
	@FindBy(xpath = "//*[@class='font-weight-bold']")
	private WebElement ProjectTitleHeader;

	//CountofSeason and Episodes
	@FindBy(xpath = "//*[@type='number']//input")
	private WebElement SelectCount;

	//Click On review Button to craete Seasons and Episods
	@FindBy(xpath = "//*[@type='submit']//span[contains (text(), ' REVIEW ')]")
	private WebElement RevieBTN;

	//Click On  FInish And Create button  to craete Seasons and Episods
	@FindBy(xpath = "//*[@class=\"ng-star-inserted\"]//span[contains (text() , 'FINISH AND CREATE')]")
	private WebElement finishAncCreateBTN;


	//General Tab
	@FindBy(xpath = "//*[@class='tab-controller']//*[contains (@data-qa, 'General')]")
	private WebElement GeneralTab;

	//Navigator Tab
	@FindBy(xpath = "//*[@class='tab-controller']//*[contains (@data-qa, 'Navigator')]")
	private WebElement NavigatorTab;


	//Add Dependents button
	@FindBy(xpath = "//button//span[contains (text(), ' Add Dependents ')]")
	private WebElement AddDependentsBTN;



	//Add Dependents button
	@FindBy(xpath = "//*[@role=\"combobox\"]")
	private WebElement dependentProjectType;

	//Details Tab
	@FindBy(xpath = "//*[@class='tab-controller']//*[contains (@data-qa, 'Details')]")
	private WebElement DetailsTab;

	//synopses Tab
	@FindBy(xpath = "//*[@class='tab-controller']//*[contains (@data-qa, 'Synopses')]")
	private WebElement SynopsesTab;

	//Related Projects Tab
	@FindBy(xpath = "//*[@class='tab-controller']//*[contains (@data-qa, 'Related Projects')]")
	private WebElement RelatedProjectsTab;

	//Contracts Tab
	@FindBy(xpath = "//*[@class='tab-controller']//*[contains (@data-qa, 'Contracts')]")
	private WebElement ContractsTab;

	//Usage Tab
	@FindBy(xpath = "//*[@class='tab-controller']//*[contains (@data-qa, 'Usage')]")
	private WebElement UsageTab;

	//Box Office Tab
	@FindBy(xpath = "//*[@class='tab-controller']//*[contains (@data-qa, 'Box Office')]")
	private WebElement BoxOfficeTab;

	//FileVault Tab
	@FindBy(xpath = "//*[@class='tab-controller']//*[contains (@data-qa, 'File Vault')]")
	private WebElement FileVaultTab;


	//Get Values from General Tab
	@FindBy(xpath = "//*[@class='row align-items-end']//input[@data-placeholder='UNIQUE IDENTIFIER']")
	private WebElement UNIQUEIDENTIFIER;

	//Copy right year
	@FindBy(xpath = "//*[@class='row align-items-end']//input[@data-placeholder='COPYRIGHT YEAR']")
	private WebElement CopyRightYear;

	//RELEASE YEAR
	@FindBy(xpath = "//*[@class='row align-items-end']//input[@data-placeholder='RELEASE YEAR']")
	private WebElement RELEASEYEAR;

	//AsseSource NetWork Selection
	@FindBy(xpath = "(//*[@class='row align-items-end']//span[contains (text() , 'ASSET SOURCE (NETWORK)')])[1]")
	private WebElement AssetSourceNetWork;
	//*[contains (@id , 'mat-select')]//span[text()='BBCA']

	//AssetSource Acquired
	@FindBy(xpath = "(//*[@class='row align-items-end']//span[contains (text() , 'ASSET SOURCE (ACQUIRED / ORIGINAL)')])[1]")
	private WebElement AssetSourceAcquired;
	//*[contains (@id , 'mat-select')]//span[text()='Acquired']

	//Assset Status
	@FindBy(xpath = "(//*[@class='row align-items-end']//span[contains (text() , 'STATUS')])[1]")
	private WebElement AssetStatus;
	//*[contains (@id , 'mat-select')]//span[text()='Active']


	//AssetSource Licensed
	@FindBy(xpath = "(//*[@class='row align-items-end']//span[contains (text() , 'ASSET SOURCE (LICENSED / OWNED)')])[1]")
	private WebElement AssetSourceLicensed;

	//*[contains (@id , 'mat-select')]//span[text()='Licensed']
	//Asset Source Scripted
	@FindBy(xpath = "(//*[@class='row align-items-end']//span[contains (text() , 'ASSET SOURCE (SCRIPTED / UNSCRIPTED)')])[1]")
	private WebElement AssetSourceScripted;
	//*[contains (@id , 'mat-select')]//span[text()='Scripted']





	//Talent Tab Selection

	@FindBy(xpath = "(//*[contains (@class , 'mat-expansion-panel')]//*[contains (@id, 'mat-expansion-panel-header')])[2]")
	private WebElement TalentTab;

	//Add Row Button
	@FindBy(xpath = "//*[@class='button-div']//*[@class='mat-button-wrapper']")
	private WebElement AddRow;

	//Add Party Name

	@FindBy(xpath = "//*[@class='ui-table-tbody']/tr[1]/td[2]//input")
	private WebElement AddPartyName;

	//Role Dropdown
	@FindBy(xpath = "//*[@class='ui-table-tbody']/tr[1]/td[3]")
	private WebElement RoleDropDown;
	//*[contains (@id , 'cdk-overlay')]//span[text() = ' Actor ']


	//Select Marquee
	@FindBy(xpath = "//*[@class='ui-table-tbody']/tr[1]/td[5]//input[@name='marquee']")
	private WebElement SelectMarquee;



	//Select ProjectFrom LeftSidePanel
	public void SelectOptionfromLeftSidePanel(String OptionType) throws Exception {
		waitForLoad();
		if(OptionType.equalsIgnoreCase("Projects")) { // for Project Selection
			waitForVisible(ProjectsButton);
			ProjectsButton.click();
			waitForVisible(AddProjectButton); // wait for Add option button and select
			AddProjectButton.click();
		}else if(OptionType.equalsIgnoreCase("Contracts")) { // For Contract Selection
			waitForVisible(ContractsButton);
			ContractsButton.click();
			waitForVisible(AddContractButton); // wait for Add option button and select
			AddContractButton.click();
		}else if(OptionType.equalsIgnoreCase("Parties")) {//For Parties Selection
			waitForVisible(PartiesButton);
			PartiesButton.click();
			waitForVisible(AddPartiesButton); // wait for Add option button and select
			AddPartiesButton.click();
		}



	}


	public void CreateProject(int linenumber) throws Exception {
		SelectOptionfromLeftSidePanel("Projects");
		action = new Actions(driver);
		readOneExcel("FTProjectInputData");
		ProjectType = readdata[linenumber][0].toString();
		Result.add(ProjectType);
		waitForVisible(ProjectTypeOption);
		clickonButton(ProjectTypeOption);
		//select Project Type from the list
		//driver.findElement(By.xpath("//*[contains (@id , 'mat-option')]//span[text() = ' "+ProjectType+" ']")).click();

		List<WebElement> ProjetcList = driver.findElements(By.xpath("//*[@class='cdk-overlay-pane']//span[contains (text(), '"+ProjectType+"')]"));

		for(WebElement ProjectTpe:ProjetcList) {
			if(ProjectTpe.getText().equalsIgnoreCase(ProjectType)) {
				ProjectTpe.click();
				break;
			}
		}
		//		driver.findElement(By.xpath("//*[@class='cdk-overlay-pane']//span[contains (text(), '"+ProjectType+"')]")).click();

		//Enter Title
		TiteleName= readdata[linenumber][1].toString();
		enterText(EnterTitle, TiteleName);
		Result.add(TiteleName);
		//Enter Title Code
		//
		//		
		//		enterText(EnterTitleCode, readdata[linenumber][2].toString());
		//		//Select Genre from the list
		//		SelectGenre.click();
		//		String GenreName=readdata[linenumber][3].toString();
		//		driver.findElement(By.xpath("//*[contains (@id , 'mat-option')]//span[text() = '"+GenreName+"']")).click();
		//		action.sendKeys(Keys.ESC).build().perform();
		//
		//		//Select Run Time 
		//		enterText(RunTime, readdata[linenumber][4].toString());
		//
		//		//Enter Keywords
		//		enterText(KeyWords, readdata[linenumber][6].toString());

		//Click on Save to create Basic Project
		clickonButton(SaveButton);

		EnterGenarelData(linenumber);
		if(ProjectType.equalsIgnoreCase("Film")) {
			System.out.println("Season and Episodes are not required for Film");
		}else {
		EnterNavigatorData();
		}
	}

	public void EnterGenarelData(int linenumber) throws Exception {
		waitForlongVisible(ProjectTitleHeader);
		clickonButton(GeneralTab);//Click on General Tab
		FilmTrackProjectID= UNIQUEIDENTIFIER.getAttribute("value");
		Result.add(FilmTrackProjectID);
		System.out.println("Project ID is -- :: "+FilmTrackProjectID);

		//Enter MandatoryFiled
		enterText(RELEASEYEAR, readdata[linenumber][2].toString());
		//Select Asset Source(Network)
		clickonButton(AssetSourceNetWork);
		AssetSource_Network =  readdata[linenumber][3].toString();

		driver.findElement(By.xpath(" //*[contains (@id , 'mat-select')]//span[text()='"+AssetSource_Network+"']")).click();

		//Select Asset Source(Acquired)
		clickonButton(AssetSourceAcquired);
		AssetSource_Acquired =  readdata[linenumber][4].toString();
		driver.findElement(By.xpath(" //*[contains (@id , 'mat-select')]//span[text()='"+AssetSource_Acquired+"']")).click();


		//Select Asset Source(Licensed)
		clickonButton(AssetSourceLicensed);
		AssetSource_Licensed =  readdata[linenumber][5].toString();
		driver.findElement(By.xpath(" //*[contains (@id , 'mat-select')]//span[text()='"+AssetSource_Licensed+"']")).click();

		if(ProjectType.equalsIgnoreCase("Film")) {
			System.out.println("Scripted / UnScripted is not avialable for Film");
		}else {
			//Select Asset Source(Scripted)
			clickonButton(AssetSourceScripted);
			AssetSource_Scripted =  readdata[linenumber][6].toString();
			driver.findElement(By.xpath(" //*[contains (@id , 'mat-select')]//span[text()='"+AssetSource_Scripted+"']")).click();
		}

		//Select Talent Tab
		scrolltoElement(TalentTab);
		clickonButton(TalentTab);

		Thread.sleep(5000);
		for(int AddParties=1;AddParties<=2;AddParties++) {

			String CastName="Add Party";
			int nextValue=0;
			int rowline=1;
			if(AddParties==2) {
				CastName=readdata[linenumber][9].toString();
				nextValue=2;

			}
			if(!CastName.equalsIgnoreCase("NA")) {
				clickonButton(AddRow);

				WebElement  PartyName = driver.findElement(By.xpath("//*[@class='ui-table-tbody']/tr["+rowline+"]/td[2]//input"));
				enterText(PartyName, readdata[linenumber][7+nextValue].toString()); // Enter Text for Party
				Thread.sleep(1000);
				WebElement PartySelect=driver.findElement(By.xpath("//*[@class='cdk-overlay-pane']//span[@class='mat-option-text']"));
				waitForVisible(PartySelect);
				PartySelect.click();

				WebElement RoleType=driver.findElement(By.xpath("//*[@class='ui-table-tbody']/tr["+rowline+"]/td[3]"));

				clickonButton(RoleType); // Role type Selection

				String RoleName=readdata[linenumber][8+nextValue].toString();
				WebElement RoleSelect =driver.findElement(By.xpath("//*[contains (@id , 'cdk-overlay')]//span[text() = ' "+RoleName+" ']"));
				waitForVisible(RoleSelect);
				RoleSelect.click();
				//Select Marquee
				//rowline

				//driver.findElement(By.xpath("(//*[@class='ui-table-tbody']/tr["+rowline+"]/td[5]//span[contains (@class, 'mat-checkbox-')])["+rowline+"]")).click();
				driver.findElement(By.xpath("//*[@class='ui-table-tbody']/tr[1]/td[8]//button//i[contains (@class,'fa fa-check' )]")).click();
				Thread.sleep(1000);
			}

		}

		//Select Status
		scrolltoElement(AssetStatus);
		clickonButton(AssetStatus); // Role type Selection
		String statusName=readdata[linenumber][11].toString();
		driver.findElement(By.xpath("//*[contains (@id , 'cdk-overlay')]//span[text() = '"+statusName+"']")).click();
		Thread.sleep(2000);

	}

	public void getSeasonsInfo() {
		String SeasonName="NoSeason";
		EpisodeCount=0;
		SeasonsList.clear();
		EpisodeNames.clear();
		for(int i=1;i<rowCount;i++) {
			if(TiteleName.equalsIgnoreCase(readdata[i][1])) {
				SeasonsList.add(readdata[i][13]);
				EpisodeNames.add(readdata[i][12]);
				if(!SeasonName.equalsIgnoreCase(readdata[i][13])) {
					SeasonCount=SeasonCount+1;
					EpisodeCount=EpisodeCount+1;
					SeasonName=readdata[i][13];
					nextNumber=i;
				}else {
					EpisodeCount=EpisodeCount+1;
					nextNumber=i;
				}
			}
		}
		System.out.println(SeasonName +" Seasons need to be create for  "+TiteleName);

		System.out.println("Total Episodes are :: "+EpisodeCount);
		System.out.println("Next count in the list is "+nextNumber);
	}


	public void activeHierarchy() {

		try {
			waitForlongVisible(ProjectTitleHeader);

			clickonButton(GeneralTab);//Click on General Tab
			//Select Asset Source(Network)
			clickonButton(AssetSourceNetWork);

			driver.findElement(By.xpath(" //*[contains (@id , 'mat-select')]//span[text()='"+AssetSource_Network+"']")).click();

			//Select Asset Source(Acquired)
			clickonButton(AssetSourceAcquired);
			driver.findElement(By.xpath(" //*[contains (@id , 'mat-select')]//span[text()='"+AssetSource_Acquired+"']")).click();


			//Select Asset Source(Licensed)
			clickonButton(AssetSourceLicensed);
			driver.findElement(By.xpath(" //*[contains (@id , 'mat-select')]//span[text()='"+AssetSource_Licensed+"']")).click();

			if(ProjectType.equalsIgnoreCase("Film")) {
				System.out.println("Scripted / UnScripted is not avialable for Film");
			}else {
				//Select Asset Source(Scripted)
				clickonButton(AssetSourceScripted);
				driver.findElement(By.xpath(" //*[contains (@id , 'mat-select')]//span[text()='"+AssetSource_Scripted+"']")).click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		statusActive("Active");
	}


	public void statusActive(String status) {
		try {

			//Select Asset Source(Network)
			//Select Status
			scrolltoElement(AssetStatus);
			clickonButton(AssetStatus); // Role type Selection
			driver.findElement(By.xpath("//*[contains (@id , 'cdk-overlay')]//span[text() = '"+status+"']")).click();

			Thread.sleep(2000);

			waitForlongVisible(ProjectTitleHeader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickonButton(NavigatorTab);//Click on General Tab

	}

	public void EnterNavigatorData() throws Exception {
		waitForlongVisible(ProjectTitleHeader);
		clickonButton(NavigatorTab);//Click on General Tab
		getSeasonsInfo();

		try {
			WebElement SeriesTitle = driver.findElement(By.xpath("//a[contains (text() , '"+TiteleName+"')]"));

			clickonButton(SeriesTitle);
			/*
			 * waitForlongVisible(ProjectTitleHeader); clickonButton(GeneralTab);//Click on
			 * General Tab statusActive("Active");
			 */
			//clickonButton(SeriesTitle);
			clickonButton(AddDependentsBTN);
			if(SeasonCount>0) {
				dependentProjectType.click();
				driver.findElement(By.xpath("//*[@role='option']//span[contains (text() , 'Season')]")).click();

				enterText(SelectCount, String.valueOf(SeasonCount));
				clickonButton(RevieBTN);
				Thread.sleep(1000);
				clickonButton(finishAncCreateBTN);

			}
			String ExistingSeason="No season";
			for(int episodes=0;episodes<EpisodeCount;episodes++) {

				try {
					WebElement SeasonNumber = driver.findElement(By.xpath("//a[contains (text() , '"+SeasonsList.get(episodes)+"')]"));
					clickonButton(SeasonNumber);
					if(!ExistingSeason.equalsIgnoreCase(SeasonsList.get(episodes))) {
						ExistingSeason=SeasonsList.get(episodes);
						activeHierarchy();
					}
					//clickonButton(SeasonNumber);
					clickonButton(AddDependentsBTN);
					dependentProjectType.click();
					if(ProjectType.equalsIgnoreCase("Series")){
						driver.findElement(By.xpath("//*[@role='option']//span[contains (text() , 'Episode')]")).click();
					}else if(ProjectType.equalsIgnoreCase("Digital Series")||ProjectType.equalsIgnoreCase("Interstitial")){
						driver.findElement(By.xpath("//*[@role='option']//span[contains (text() , 'Episode')]")).click();
					}
					//System.out.println(Collections.frequency(SeasonsList, SeasonsList.get(episodes)));

					enterText(SelectCount, String.valueOf(1));
					WebElement EpisodeName =driver.findElement(By.xpath("//*[@data-placeholder='Project Name']"));
					enterText(EpisodeName, EpisodeNames.get(episodes));
					clickonButton(RevieBTN);
					Thread.sleep(1000);
					clickonButton(finishAncCreateBTN);
					driver.findElement(By.xpath("//a[contains (text() , '"+EpisodeNames.get(episodes)+"')]")).click();
					activeHierarchy();
					System.out.println(EpisodeNames.get(episodes)+" Episode was Created Successfully for -- "+TiteleName);

				}catch(Exception e) {
					System.out.println("Exception need to write");
				}
			}


		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
