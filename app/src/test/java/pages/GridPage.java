package pages;

import org.openqa.selenium.WebDriver;

public class GridPage extends BasePage {

    private String cell = "//*[id='root']/div/";
    private String mainTable = "//*[id='root']/div/table";
    
    public GridPage(WebDriver driver) {
        super(driver);
    }


    public GridPage() {
    }


    public void navigateToGrid(){
        navigateTo("https://www.1v2njkypo4.csb.app.es");
    }

    public String getValueFromGrid(int row, int column){
        return getValueFromTable(cell, row, column);
    }

    public boolean cellStatus(){
        return elementIsDisplayed(mainTable);
    }


    private boolean elementIsDisplayed(String mainTable2) {
        return false;
    }

}


