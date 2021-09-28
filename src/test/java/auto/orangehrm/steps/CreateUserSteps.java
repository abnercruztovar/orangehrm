/**
 * 
 */
package auto.orangehrm.steps;

import org.junit.Assert;

import auto.orangehrm.model.Role;
import auto.orangehrm.model.Status;
import auto.orangehrm.model.User;
import auto.orangehrm.pages.AdminPage;
import auto.orangehrm.pages.LoginPage;
import auto.orangehrm.pages.UserPage;
import auto.orangehrm.util.GB;
import net.thucydides.core.annotations.Step;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class CreateUserSteps {

	LoginPage lPage;
	AdminPage aPage;
	UserPage uPage;
	User user;

	@Step
	public void loginAndOpenAdminPage() {
		lPage.open();
		lPage.userLogin("Admin");
		lPage.passLogin("admin123");
	}

	@Step
	public void selectAdminPage() {
		aPage.getAdminMenu().click();
		aPage.getBtnAddUser().click();
	}

	@Step
	public void createUser(String employeeName, String password, String role, String status, String username) {
		User usr = GB.of(new User()).push(u -> u.setName(employeeName)).push(u -> u.setUserName(username))
				.push(u -> u.setPassword(password)).push(u -> u.setRole(Role.valueOf(role)))
				.push(u -> u.setStatus(Status.valueOf(status))).build();

		this.user = usr;

		uPage.addUser(usr);
	}

	@Step
	public void saveUser() {
		String msj = uPage.saveUser();

		if (msj != null) {
			aPage.getAdminMenu().click();
		} else {
			Assert.assertTrue(true);

		}

	}

}
