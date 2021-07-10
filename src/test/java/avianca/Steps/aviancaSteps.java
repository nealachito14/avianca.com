package avianca.Steps;

import avianca.Pages.aviancaPagesBooking;
import avianca.Pages.aviancaPagesO;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class aviancaSteps {
	aviancaPagesO avPages;
	aviancaPagesBooking booking;

	@Step
	public void open_browser() {
		avPages.open();
	}

	@Step
	public void closeCookies(){
		avPages.closeCookies();
	}
	
	@Step
	public void selectFlightType(String type) {
		avPages.selectFlightType(type);
	}
	
	@Step
	public void selectFrom(String from) {
		avPages.selectFrom(from);
	}
	@Step
	public void selectTo(String to){
		avPages.selectTo(to);
	}
	@Step
	public void selectFromDate(String date){
		avPages.selectFromDate(date);
	}
	@Step
	public void selectToDate(String date){
		avPages.selectToDate(date);
	}
	@Step
	public void clickPassengers(){
		avPages.clickPassengers();
	}
	@Step
	public void clickAdults(int passengers){
		avPages.clickAdults(passengers);
	}
	@Step
	public void clickChilds(int passengers){
		avPages.clickChilds(passengers);
	}
	@Step
	public void clickBabies(int passengers){
		avPages.clickBabies(passengers);
	}
	@Step
	public void clickBtnContinuar(){
		avPages.clickBtnContinuar();
	}
	@Step
	public void clickBtnSearchFlight(){
		avPages.clickBtnSearchFlight();
	}
	@Step
	public void selectSecondFligth(){
		booking.selectSecondFligth();
	}
	@Step
	public void selectTypeFlight(){
		booking.selectTypeFlight();
	}
	@Step
	public void selectDetails(){
		booking.selectDetails();
	}
	@Step
	public void generarAlerta(){
		booking.generarAlerta();
	}
	@Step
	public void validateFlight(){
		booking.validateFlight();
	}
	
}
