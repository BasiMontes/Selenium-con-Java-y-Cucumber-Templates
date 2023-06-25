package steps;

import org.junit.Assert;
import io. cucumber. java.en.*;
import io. restassured. response.Response;
import io. restassured. response. ValidatableResponse;
import io. restassured. specification.RequestSpecification;
import pages. TradeMePage;
import static io. restassured.RestAssured.*;

import java.util.List;

public class TradeMeSteps {

    private ValidatableResponse json:
    private static RequestSpecification request;
    private Response response;

    TradeMePage trademe - new TradeMePage();

    @Given("^I navigate to the TradeMe Motor page$")
    public void navipateToTradeMeMotorI() {
        trademe.navigateToTradeMeMotor();
    }

    @When("^I select the car make (.+)$")
    public void selectMake (String make){
        trademe.selectMakeFronDropdown(make);
    }

    @Then("^I can see it has (.+) records in the results$")
    public void printAmount(String expectedAmount0fResults){
        trademe.clickSearch();
        Assert.assertEquals("Showing "+expectedAmountOfResults+" results", trademe. resultsAmount());
    }

    @Then("^I can verify that the number of car makes is (\\d+)$")
    public void returnAmountofMakes (int makeAmount){
        int expectedAmount = makeAmount;
        int actualAmount = trademe.makeDropdownSize();
        Assert.assertEquals(expectedAmount, actualAmount);
    }

    @Given("^I send the request to the endpoints")
    public void sendGETRequest (){
         request= given()
         .log().all()
         .param(parameterName: "", ...parameterValues:"");
    }

    @Then("^I can see there are (\\d+) car makes$")
    public void validateAmountofMakes(int expectedMakeAmount){
     response = request
                .when()
                .get(path:"https://api.trademe.co.nz/v1/Categories/UsedCars.json");
                json = response.then().statusCode(expectedStatusCode: 200);
                List<String> jsonResponse = response.jsonPath().getList(path:"Subcategories.Name");
                Assert.assertEquals(message:"Mismatch on the expected total.",expectedMakeAmount,jsonResponse.size());
    }


}





