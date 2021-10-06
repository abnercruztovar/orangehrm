/**
 * 
 */
package auto.orangehrm.StepsDefinitions;

import java.io.IOException;

import auto.orangehrm.steps.GetUserListSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class GetUserListStepDefinition {

	@Steps
	GetUserListSteps getUserListSteps;

	@Given("^The user is on the Search Users page Orange HRM$")
	public void theUserLoginAndOpen() {
		getUserListSteps.loginAndOpen();
	}

	@When("^Read a Excel File with the information about Roles$")
	public void searchUserByRol() throws Exception {
		getUserListSteps.searchUsersByRole();
	}

	@Then("^The user verifies that the list of users is wrote in excel file$")
	public void saveUsersInfo() throws IOException {
		getUserListSteps.saveUserInfo();
	}

}
