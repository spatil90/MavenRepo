package stepDefinitions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageObjects.maven.TestPage;
import com.practice.maven.Basic;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestingPageStepDef extends Basic {
	@Given("^Initiate browser with chrome$")
    public void initiate_browser_with_chrome() throws Throwable {
		cd=DriverInitialization();
        
    }

    @When("^navigated to \"([^\"]*)\" website$")
    public void navigated_to_something_website(String strArg1) throws Throwable {
    	cd.get(strArg1);
		cd.manage().window().maximize();
    }

    @Then("^click on \"([^\"]*)\" button to go to testing page $")
    public void click_on_something_button_to_go_to_testing_page(String strArg1) throws Throwable {
    	TestPage tp=new TestPage(cd);
		wait = new WebDriverWait(cd, 5);
		//wait.until(ExpectedConditions.visibilityOf(tp.closepopup()));
		
		if(tp.closepopupsize()>0) {
		tp.getClosePopupButton().click();
		System.out.println("Default pop up closed");
		}
		else
			System.out.println("Pop up not displayed");
		tp.getInputForms().click();
		System.out.println("Clicked on Input Forms");
	
        
    }

    @And("^close browser$")
    public void close_browser() throws Throwable {
    	cd.close();
    }

}
