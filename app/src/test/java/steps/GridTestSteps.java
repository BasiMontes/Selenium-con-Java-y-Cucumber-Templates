package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GridPage;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class GridTestSteps {

    private GridPage gridpage;

    public void GridSteps() {
        this.gridpage = new GridPage();
    }

    @Given("^I navigate  to the static table$")
    public void navigateToGridPage() {
        gridpage.navigateToGrid();
    }

    @Then("I should see {string} in the results")
    public void returnValue() {
        final String value = gridpage.getValueFromGrid(3,2);
        //assertEquals. Compara exactamente el valor que se le de 
        Assert.assertEquals("1 a", value);
    }

    public void theTableIsThere() {
        //assertTrue. Booleano positivo, Sí
        Assert.assertTrue("Explotó todo", gridpage.cellStatus());
    }

    public void theTableIsNOTThere() {
        //assertFalse. Booleano negativo, NO
        Assert.assertFalse("No está", gridpage.cellStatus());
    }

}