package runner;

import org.junit.runner.RunWith;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    //Extensión para generar los reportes
    plugin = {"com.aventstack.extentreport.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"},
    monochrome = true //, El output es más limpio
    tags = "@Amazon"
    //Más de un tag. tags = {"@Grid, @Test,..."}
)

public class runner {
    //Después de cada test me cierras el navegador
    @AfterClass
    public void cleanDriver(){
        BasePage.CloseBrowser();
    }

    static {
        String chromeDriverPath = "C:\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }

    public static void main(String[] args) {
        // Definir el objeto driver y asignarle una instancia de ChromeDriver
        WebDriver driver = new ChromeDriver();

        driver.quit(); // Salir del navegador
    }

}
