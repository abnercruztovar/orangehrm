/**
 * 
 */
package auto.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import auto.orangehrm.model.Employee;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class EmployeePage extends PageObject {

	private static final String EMPLOYEE_EXIST = "//*[contains(text(),'Failed To Save: Employee Id Exists')]";
	private Employee employee;

	@FindBy(id = "firstName")
	private WebElementFacade txtfirstName;

	@FindBy(id = "middleName")
	private WebElementFacade txtMidleName;

	@FindBy(id = "lastName")
	private WebElementFacade txtLastName;

	@FindBy(id = "employeeId")
	private WebElementFacade txtId;

	@FindBy(id = "btnSave")
	private WebElementFacade btnSave;

	@FindBy(xpath = "/html/body/div[1]/div[3]/div/div[1]/div/h1")
	private WebElementFacade userNamePageHolder;

	@FindBy(xpath = "//*[contains(text(),'Failed To Save: Employee Id Exists')]")
	private WebElementFacade msjEmployeeExist;

	public void addEmployee(Employee employee) {

		this.employee = employee;
		txtfirstName.clear();
		txtfirstName.sendKeys(employee.getFirstName());
		txtMidleName.clear();
		txtMidleName.sendKeys(employee.getMiddleName());
		txtLastName.clear();
		txtLastName.sendKeys(employee.getLastName());
		txtId.clear();
		txtId.sendKeys(employee.getId().toString());

	}

	public String saveEMployee() {
		btnSave.click();
		WebElement msj = null;

		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 2);
			msj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMPLOYEE_EXIST)));
		} catch (Exception e) {
			e.getStackTrace();
		}

		employee.setExist(true);

		return msj.getText();
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the userNamePageHolder
	 */
	public WebElementFacade getUserNamePageHolder() {
		return userNamePageHolder;
	}

	/**
	 * @param userNamePageHolder the userNamePageHolder to set
	 */
	public void setUserNamePageHolder(WebElementFacade userNamePageHolder) {
		this.userNamePageHolder = userNamePageHolder;
	}

}
