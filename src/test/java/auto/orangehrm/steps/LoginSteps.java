/**
 * 
 */
package auto.orangehrm.steps;

import auto.orangehrm.pages.LoginPage;
import net.thucydides.core.annotations.Step;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class LoginSteps {

	LoginPage lPage;

	@Step
	public void openBrowser() {
		lPage.open();
	}

	@Step
	public void typeUserName(String user) {
		lPage.userLogin(user);
	}

	@Step
	public void typeUserPassword(String pass) {
		lPage.passLogin(pass);
	}

	@Step
	public void clickLogin() {
		lPage.btnLogin();
	}

	@Step
	public void validateLogin() {
		lPage.getMessage();
	}

}
