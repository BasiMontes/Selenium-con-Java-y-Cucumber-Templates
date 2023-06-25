package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;       
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //ESPERA IMPLÍCITA EN CADA PASO, ESPERAS X TIEMPO
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  

    }
    
    public static void navigateTo(String url){
        driver.get(url); 
    }

    public static void CloseBrowser() {
        driver.quit();
    }


    private WebElement Find(String locator){
        //ESPERA EXPLÍCITA EN CADA PASO, SI LO ENCUENTRA ANTES DEL TIEMPO MARCADO SIGUE HACIA ADELANTE
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    //Devuelve la cantidad de elementos de una lista
    public int dropdownSize(String locator){
        Select dropdown I new Select (Find(locator));
        List<WebELement> dropdownOptions - dropdown. getOptions();
        return dropdownOptions.size();
    }


    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(valueToSelect);
    }

    //Eligiendo el valor dentro de un dropdown
    public void selectFromDropdownByIndex(String locator, Integer valueToSelect){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleclick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightclick(String locator){
        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        return Find(cellINeed).getText();
    }

    public void sendValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        Find(cellToFill).sendKeys(stringToSend);
    }

    //FRAMES
    public void SwicthToiFrame(String iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    //ALERTS + AÑADIR MENSAJES DE ERROR
    public void dismissAlert(){
        try{
            driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }
        
    }

    public String textFromElement(String locator){
        return Find(locator).getText();
    }

    public boolean elementEnabled(String locator) {
        //Para ver si un elemento está disponible
        return Find(locator).isEnabled();
    }

    public boolean elementDisplayed(String locator) {
        //Para ver si un elemento se está mostrando
        return Find(locator).isDisplayed();
    }

    public boolean elementSelected(String locator) {
        //Para ver si un elemento está seleccionado
        return Find(locator).isSelected();
    }

    //Buscar un elemento en una lista
    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
        
    }

    //Te traes una lista de elementos y clickas en uno
    public void selectNthElement(String locator, int index){
        List<WebElement> results = driver. findElements (By.xpath(locator));
        results.get(index).click();
    }



}
