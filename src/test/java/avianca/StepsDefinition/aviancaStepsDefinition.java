package avianca.StepsDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import avianca.Steps.aviancaSteps;
import avianca.Utils.DataDrivenExcel;
import avianca.Utils.Excel;
import avianca.Utils.helpers;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;



public class aviancaStepsDefinition {
	helpers helpers = new helpers();
	DataDrivenExcel drivenExcel = new DataDrivenExcel();
	List<Map<String,String>> processExcel;
	Map<String,String> data = new HashMap<String,String>();


	@Steps
	aviancaSteps avSteps;

	@Given("the user in on the Avianca.com page {int}")
	public void theUserInOnTheAviancaComPage(int fila, DataTable datosExcel) {
	    // Write code here that turns the phrase above into concrete action
		processExcel = datosExcel.asMaps(String.class,String.class);
		Excel excel = new Excel(processExcel.get(0).get("Ruta Excel"), processExcel.get(0).get("Pestana"),true,fila);
		data = drivenExcel.leerExcel(excel);
		avSteps.open_browser();
	}

	@When("the user completes the form")
	public void theUserCompletesTheForm() {

		avSteps.closeCookies();
		avSteps.selectFlightType(data.get("Type of Fligth"));
		avSteps.selectFrom(data.get("From"));
		avSteps.selectTo(data.get("To"));
		helpers.esperaSelenium(2);
		avSteps.selectFromDate(data.get("Departure Date"));
		avSteps.selectToDate(data.get("Return Date"));
		avSteps.clickPassengers();
		avSteps.clickAdults(Integer.parseInt(data.get("Adults")));
		avSteps.clickChilds(Integer.parseInt(data.get("Childs")));
		avSteps.clickBabies(Integer.parseInt(data.get("Babies")));
		avSteps.clickBtnContinuar();
		avSteps.clickBtnSearchFlight();
		helpers.esperaSelenium(18);
		avSteps.selectDetails();
		avSteps.generarAlerta();
		//avSteps.selectSecondFligth();
		//avSteps.selectTypeFlight();

	}

	@Then("the user validates information processed correctly")
	public void theUserValidatesInformationProcessedCorrectly() {
	    // Write code here that turns the phrase above into concrete actions
		avSteps.validateFlight();
	}
	
	
}
