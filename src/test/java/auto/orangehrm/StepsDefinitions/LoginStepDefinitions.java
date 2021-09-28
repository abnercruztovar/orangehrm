/**
 * 
 */
package auto.orangehrm.StepsDefinitions;

import auto.orangehrm.steps.LoginSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class LoginStepDefinitions {

	@Steps
	LoginSteps lSteps;

	@Given("^The user is on the Orange HRM page$")
	public void theUserIsOnOrangeHRMPage() {
		lSteps.openBrowser();
	}

	@When("^input user credentials \"([^\"]*)\" \"([^\"]*)\"$")
	public void inputUserCredentials(String user, String pass) {
		lSteps.typeUserName(user);
		lSteps.typeUserPassword(pass);
		lSteps.clickLogin();

	}

	@Then("^the user verifies that Dashboard Page is displayed$")
	public void userVerifiesThatLoginSuccess() {
		lSteps.validateLogin();
	}

}
