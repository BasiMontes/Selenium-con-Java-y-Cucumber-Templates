package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.*;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
//import cucumber.api.After;
//import cucumber.api.java.AfterClass;
import pages.BasePage;

public class Hooks extends BasePage {

    public Hooks(){
        super(driver);
    }

    //Añadir Captura a los reportes cuando algo falla
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            scenario.write("Esto ha fallado");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }


}
