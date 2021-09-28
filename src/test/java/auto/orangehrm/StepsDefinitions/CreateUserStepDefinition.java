/**
 * 
 */
package auto.orangehrm.StepsDefinitions;

import auto.orangehrm.steps.CreateUserSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class CreateUserStepDefinition {

	@Steps
	CreateUserSteps createUserSteps;

	@Given("^The admin is on the Orange HRM/User page$")
	public void theUserIsOnOrangeHRMPage() {
		createUserSteps.loginAndOpenAdminPage();
		createUserSteps.selectAdminPage();
	}

	@When("^User adds information about new User \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void addNewUserToOrangeHRM(String employeeName, String password, String role, String status,
			String username) {
		createUserSteps.createUser(employeeName, password, role, status, username);
	}

	@Then("^The user verifies that user exist in the results$")
	public void saveNewUSer() {
		createUserSteps.saveUser();
	}

}
