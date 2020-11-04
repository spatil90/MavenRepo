package stepDefinitions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageObjects.maven.HomePage;
import com.pageObjects.maven.TestPage;
import com.practice.maven.Basic;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LandingPageStepDef extends Basic {


		@Given("^Initiate browser with chrome$")
		public void initiate_browser_with_chrome() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			cd = DriverInitialization();
		    
		}

		@When("^navigated to \"([^\"]*)\" website$")
		public void navigated_to_website(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			cd.get(arg1);
		    
		}

		@Then("^click on \"([^\"]*)\" button to go to testing page$")
		public void click_on_button_to_go_to_testing_page(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			HomePage hp = new HomePage(cd);
			hp.getDemoWebsiteButton().click();TestPage tp = new TestPage(cd);
			wait = new WebDriverWait(cd, 5);
			if(tp.closepopupsize()>0) {
				tp.getClosePopupButton().click();
				//log.info("Default pop up closed");
				}
				else
					System.out.println("Pop up not displayed");
					//log.info("Pop up not displayed");
			
		}
		
		@Then("^close browser$")
		public void close_browser() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			cd.close();
		}
		    
		}



	


