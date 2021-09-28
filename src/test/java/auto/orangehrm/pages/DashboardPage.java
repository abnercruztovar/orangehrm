/**
 * 
 */
package auto.orangehrm.pages;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class DashboardPage extends PageObject {

	@FindBy(id = "welcome")
	private WebElementFacade txtWelcome;

	public String getWelcome() {
		return txtWelcome.getText();
	}

}
