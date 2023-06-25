package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;

public class GoogleSteps {

    private GooglePage googlePage;

    public GoogleSteps() {
        this.googlePage = new GooglePage();
    }

    @Given("I am on the Google home page")
    public void iAmOnTheGoogleHomePage() {
        googlePage.navigateToGoogle();
    }

    @When("I search for {string}")
    public void iSearchFor(String searchCriteria) {
        googlePage.enterSearchCriteria(searchCriteria);
        googlePage.clickGoogleSearch();
    }

    @Then("I should see {string} in the results")
    public void iShouldSeeInTheResults(String expectedText) {
        googlePage.verifyTextInResults(expectedText);
    }
}
