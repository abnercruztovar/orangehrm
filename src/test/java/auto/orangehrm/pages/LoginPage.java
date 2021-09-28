/**
 * 
 */
package auto.orangehrm.pages;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
@DefaultUrl("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers")
public class LoginPage extends PageObject {

	public static final String INVALID_CREDENTIALS = "Invalid credentials";
	public static final String PASSWORD_EMPTY = "Password cannot be empty";
	public static final String USERNAME_EMPTY = "Username cannot be empty";

	DashboardPage dPage;

	@FindBy(id = "txtUsername")
	private WebElementFacade userName;

	@FindBy(id = "txtPassword")
	private WebElementFacade userPassword;

	@FindBy(id = "btnLogin")
	private WebElementFacade btnLogin;

	@FindBy(id = "spanMessage")
	private WebElementFacade errMessage;

	public void userLogin(String user) {
		userName.typeAndTab(user);
	}

	public void passLogin(String pass) {
		userPassword.typeAndEnter(pass);
	}

	public void btnLogin() {
		btnLogin.click();
	}

	public void getMessage() {

		String msj = "";
		if (errMessage.isPresent()) {
			msj = errMessage.getText();
			validateMessage(msj);
		} else {
			msj = dPage.getWelcome();
			Assert.assertTrue(msj.contains("Welcome"));
		}
	}

	public void validateMessage(String msj) {
		if (msj.contains(PASSWORD_EMPTY)) {
			Assert.assertTrue(msj.contains(PASSWORD_EMPTY));
		} else if (msj.equals(USERNAME_EMPTY)) {
			Assert.assertTrue(msj.contains(USERNAME_EMPTY));
		} else {
			Assert.assertTrue(msj.contains(INVALID_CREDENTIALS));
		}
	}

}
