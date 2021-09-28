/**
 * 
 */
package auto.orangehrm.steps;

import org.junit.Assert;

import auto.orangehrm.model.Employee;
import auto.orangehrm.pages.AdminPage;
import auto.orangehrm.pages.EmployeePage;
import auto.orangehrm.pages.LoginPage;
import auto.orangehrm.util.GB;
import net.thucydides.core.annotations.Step;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class CreateEmployeeSteps {

	LoginPage lPage;
	EmployeePage ePage;
	AdminPage aPage;
	Employee emp;

	@Step
	public void loginAndOpenPimPage() {
		lPage.open();
		lPage.userLogin("Admin");
		lPage.passLogin("admin123");
	}

	@Step
	public void selectPimPage() {
		aPage.getPimMenu().click();
		aPage.getBtnAddEmployee().click();
	}

	@Step
	public void createEmployee(String firstName, String middleName, String lastName, String id) {
		Employee employee = GB.of(new Employee()).push(e -> e.setFirstName(firstName))
				.push(e -> e.setMiddleName(middleName)).push(e -> e.setLastName(lastName))
				.push(e -> e.setFullName(firstName, middleName, lastName)).push(e -> e.setId(Integer.valueOf(id)))
				.build();
		ePage.addEmployee(employee);

		emp = ePage.getEmployee();

	}

	@Step
	public void saveEmployee() {
		String msj = ePage.saveEMployee();

		if (msj != null) {
			aPage.getPimMenu().click();
		} else {
			Assert.assertTrue(
					ePage.getUserNamePageHolder().getText().toLowerCase().equalsIgnoreCase(emp.getFullName()));
		}

	}

}
