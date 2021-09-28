/**
 * 
 */
package auto.orangehrm.StepsDefinitions;

import auto.orangehrm.steps.CreateEmployeeSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class CreateEmployeeStepDefinition {

	@Steps
	CreateEmployeeSteps createEmployeeSteps;

	@Given("^The user is on the Orange HRM/PIM page$")
	public void theUserIsOnOrangeHRMPage() {
		createEmployeeSteps.loginAndOpenPimPage();
		createEmployeeSteps.selectPimPage();
	}

	@When("^User adds information about new employee \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void addNewEmployeeToOrangeHRM(String firstName, String middleName, String lastName, String id) {
		createEmployeeSteps.createEmployee(firstName, middleName, lastName, id);
	}

	@Then("^The user verifies that user Personal Details is displayed$")
	public void saveNewEmployee() {
		createEmployeeSteps.saveEmployee();
	}

}
