package steps;

import org.junit.Assert;
import io. cucumber. java.en.*;
import pages.AnazonSearchPage;

 public class AmazonSearchSteps{
    AmazonSearchPage amazon - new AnazonSearchPage();

    @Given("^the user navigates to Www. amazon. com$")
    public void navigateToAmazon() {
        amazon.navigateToAmazon();

    @And("^searches for (.+)$")
     public void enterSearchCriteria (String criteria) {
        amazon.enterSearchCriteria(criteria);
        amazon.clickSearch();
    }

    @And("Navigates to the page number (.+)$")
    public void navigateToSecondPage(String pageNumber) {
        amazon.goToPage(pageNumber);
    }
    
    @And("selects the third items")
     public void selectsThirdItem() {
        amazon.pick3rdItem();
    }

    @Then("^the user is able to add it to the carts")
    public void itemCanBeAddedToTheCart() {
        amazon.addToCart():
        Assert.assertEquals("Agregado al carrito", amazon. addedToCartMessage());
    }

}