package avianca.Pages;

import avianca.Utils.escribirLog;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.junit.Assert;

import org.openqa.selenium.By;

import org.openqa.selenium.support.FindBy;

import java.util.List;

public class aviancaPagesBooking extends PageObject {
    @FindBy(xpath = "//div[contains(text(),'Desde')]")
    List<WebElementFacade> secondFlight;
    @FindBy(xpath = "//button[@class='ff-price-container']")
    List<WebElementFacade> buttonCards;
    @FindBy(xpath = "//span[@class='flight-detail-link']")
    List<WebElementFacade> viewDetails;

    @FindBy(xpath = "//div[@class='flight-features']/div[@class='flight-time']/div[@class='hour']")
    List<WebElementFacade> validate;

    @FindBy(xpath = "//span[@class='flight-segment-date-location']/span[@class='flight-segment-date']")
    List<WebElementFacade> finals;


    @FindBy(xpath = "//span[@class='flight-details-header-location-date']")
    WebElementFacade titleViewDetails;
    String base = "//span[@class='flight-segment-date-location']";




    public void selectSecondFligth(){
        secondFlight.get(2).click();
    }
    public void selectTypeFlight(){
        buttonCards.get(buttonCards.size()-1).click();
    }
    public void selectDetails(){
            viewDetails.get(1).click();
    }
    public void generarAlerta(){
        String rutaFecha = titleViewDetails.getText();
        String ida = getDriver().findElement(By.xpath("("+base+")[1]")).getText();
        String vuelta = getDriver().findElement(By.xpath("("+base+")[2]")).getText();
        escribirLog log = new escribirLog();
        log.escribir(rutaFecha,ida,vuelta);

    }
    public void validateFlight(){
        String Original = validate.get(2).getText();
        String Original2 = validate.get(3).getText();
        Assert.assertEquals(Original, finals.get(0).getText());
        Assert.assertEquals(Original2, finals.get(1).getText());
        System.out.println(Original+" -vs- "+finals.get(0).getText());
        System.out.println(Original2+" -vs- "+finals.get(1).getText());
    }
}
