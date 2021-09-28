/**
 * 
 */
package auto.orangehrm.steps;

import org.openqa.selenium.WebElement;

import auto.orangehrm.pages.AdminPage;
import auto.orangehrm.pages.LoginPage;
import auto.orangehrm.pages.UserPage;
import net.thucydides.core.annotations.Step;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class DeleteUserSteps {

	LoginPage lPage;
	AdminPage aPage;
	UserPage uPage;

	@Step
	public void loginAndOpenAdminUsersPage() {
		lPage.open();
		lPage.userLogin("Admin");
		lPage.passLogin("admin123");
	}

	@Step
	public void selectAdminUsersPage() {
		aPage.getAdminMenu().click();
	}

	@Step
	public void deleteUser(String userName) {
		WebElement usrLink = uPage.findUser(userName, 1);

		if (usrLink != null) {
			usrLink.click();
			uPage.deleteUser(usrLink);
		}

	}

	@Step
	public void confirmDelete() {
		uPage.confirmDelete();
	}

}
