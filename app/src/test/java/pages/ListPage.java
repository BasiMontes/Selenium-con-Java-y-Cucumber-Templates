package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

public class ListPage extends BasePage {

    private String searchField = "//body/form[1]/input[1]";
    private String searchResults = "name";

    public ListPage(){
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("https://andreibr.github.io/JS30/0AjaxTypeAhead/index.html");
    }

    public void enterSearchCriteria(String state) throws InterruptedException {
        try{
        Thread.sleep(600);
        write(searchField, state);
        }catch(NoSuchElementException e){
            System.out.println("The WebElement search field couldn't be found");
            e.printStackTrace();
        }
    }

    public List<String> getAllSearchResults(){
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> StringFromList = new ArrayList<String>();
        for (WebElement e :list){
            StringFromList.add(e.getText());
        }
        return StringFromList;
    }

}


