package pages;

public class TradeMePage extends BasePage {

     private String makeDropdown = "(//select[@name='selectdMake'])";
     private String searchButton = "//button[@type='submit']";
     private String resultsLabel = "//hl[@class='tm-search-header-result-count_heading ng-star-inserted*]";

    public TradeMePage(){
        super(driver);
    }
    public void navigateToTradefeMotor()
        navigateTo(url: "https://www.trademe.co.nz/a/motors");
    }

    public void selectMakeFromDropdown(String make){
        selectFromDropdownByText (makeDropdown,make); 
    }

    public void clickSearch(){
        clickElement(searchButton);
    }

    public int makeDropdownSize(){
        return dropdownSize(makeDropdown);
    }

    public String resultsAmount(){
        return textFromElement(resultsLabel);
    }

}
