package avianca.Pages;

import avianca.Utils.helpers;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.avianca.com/co/es/")
public class aviancaPagesO extends PageObject {

	helpers helpers = new helpers();

	@FindBy(name = "cookies-confirm")
	WebElementFacade btnCookies;
	
	@FindBy(xpath ="//a[contains(text(),'Ida y vuelta')]")
	WebElementFacade btnIdayVuelta;
	
	@FindBy(xpath ="//a[contains(text(),'Solo ida')]")
	WebElementFacade btnSoloIda;
	
	@FindBy(xpath = "//input[contains(@class,'form-control airport pbOrigen airport_ida airport_mvvn valid')]")
	WebElementFacade txtFrom;
	
	@FindBy(xpath = "(//ul[@class='counters hidden-counters']/li[1])[1]")
	WebElementFacade slFrom;
	
	@FindBy(xpath = "(//input[contains(@class,'form-control airport pbDestino airport_regreso airport_mvvn')]) [2]")
	WebElementFacade txtTo;

	@FindBy(xpath = "(//ul[@class='counters hidden-counters']/li[1])[2]")
	WebElementFacade slTo;

	@FindBy(xpath = "//*[contains(@id,'pbFechas_1_')]")
	WebElementFacade fechaIda;

	@FindBy(xpath = "(//*[contains(@id,'pbPasajeros_1')] )[2]")
	WebElementFacade pasajeros;

	@FindBy(xpath = "(//div[@class='controls adults']//i[contains(@class,'material-icons') and contains(text(),'add')])[2]")
	WebElementFacade btnAddAdults;

	@FindBy(xpath = "(//div[@class='controls noadults' and contains(@aria-label,'Ni')]//i[contains(@class,'material-icons') and contains(text(),'add')])[2]")
	WebElementFacade btnAddChilds;

	@FindBy(xpath = "(//div[@class='controls noadults' and contains(@aria-label,'Menores')]//i[contains(@class,'material-icons') and contains(text(),'add')])[2]")
	WebElementFacade btnAddBabies;

	@FindBy(xpath = "(//button[contains(@aria-label,'Continuar, cerrar cuadro de pasajeros') and @class='btn btn-secondary secondary close-me hidden-xs'])[2]")
	WebElementFacade btnContinuar;

	@FindBy(xpath = "(//button[@class='btn primary btn-codepromo pull-btn rojo'])[1]")
	WebElementFacade btnSearchFlight;
	@FindBy(xpath = "//*[@id='teaserc9cceaff-7699-4ba4-a32a-9cc8da84c5d7']/iframe")
	WebElementFacade frame;
	@FindBy(xpath = "/html/body/section/form/ul/li[4]/div/img")
	WebElementFacade closeButtonFrame;



	public void closeCookies(){
		btnCookies.click();
	}
	public void selectFlightType(String type) {
		if(type.equals("Ida y vuelta")) {
			btnIdayVuelta.click();
		}else if(type.equals("Solo ida")) {
			btnSoloIda.click();
		}
	}
	
	public void selectFrom(String from) {

		txtFrom.click();
		txtFrom.sendKeys(from);
		slFrom.click();
	}
	public void selectTo(String to){

		txtTo.click();
		txtTo.sendKeys(to);
		slTo.click();
		closeIframe();
	}
	public void selectFromDate(String date){

		WebElement fechaIdaSel = getDriver().findElement(By.xpath("(//*[contains(@class,'month-container') and contains(@data-month,'"+helpers.formatDate(date)+"') ])[2]/div[@class='month']/div[@data-day='"+date+"']"));
		fechaIda.click();
		fechaIdaSel.click();
	}
	public void selectToDate(String date){
		WebElement fechaRegresoSel = getDriver().findElement(By.xpath("(//*[contains(@class,'month-container') and contains(@data-month,'"+helpers.formatDate(date)+"') ])[2]/div[@class='month']/div[@data-day='"+date+"']"));
		fechaRegresoSel.click();
	}
	public void clickPassengers(){
		pasajeros.click();
	}
	public void clickAdults(int passengersAd){
		helpers.clicksPass(passengersAd-1,btnAddAdults);
	}
	public void clickChilds(int passengersAd){
		helpers.clicksPass(passengersAd,btnAddChilds);
	}
	public void clickBabies(int passengersAd){
		helpers.clicksPass(passengersAd,btnAddBabies);
	}
	public void clickBtnContinuar(){
		btnContinuar.click();
	}
	public void clickBtnSearchFlight(){

		btnSearchFlight.click();
	}
	public void closeIframe(){
		helpers.esperaSelenium(5);
		for(String handle: this.getDriver().getWindowHandles()){
			this.getDriver().switchTo().frame(frame);
		}
		closeButtonFrame.click();
		for(String handle: this.getDriver().getWindowHandles()){
			this.getDriver().switchTo().defaultContent();
		}
	}
		

	
}
