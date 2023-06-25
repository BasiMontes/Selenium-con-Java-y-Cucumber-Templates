package pages;

public class GooglePage extends BasePage {

    private String searchButton = "//input[@value='Buscar con Google']";
    private String searchTextField = "//input[@title='Buscar']";
    private String firstResult = "";
    
    public GooglePage(){
        super(driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.es");
    }

    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField, criteria);
    }

    public String getResultsText() {
        return null;
        }

    public void verifyTextInResults(String expectedText) {
    }

    public String firstResult(){
        return textFromElement(firstResult);
    }
}


