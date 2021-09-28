/**
 * 
 */
package auto.orangehrm.StepsDefinitions;

import auto.orangehrm.steps.DeleteUserSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class DeleteUSerStepDefinition {

	@Steps
	DeleteUserSteps deleteUserSteps;

	@Given("^The user is on the Orange HRM/Admin page$")
	public void theUserIsOnOrangeHRMAdminPage() {
		deleteUserSteps.loginAndOpenAdminUsersPage();
		deleteUserSteps.selectAdminUsersPage();
	}

	@When("^User adds information about the user to delete \"([^\"]*)\"$")
	public void findAndDeleteUserFromOrangeHRM(String userName) {
		deleteUserSteps.deleteUser(userName);

	}

	@Then("^The user confirms that the user were deleted$")
	public void confirmDelete() {
		deleteUserSteps.confirmDelete();
	}

}
