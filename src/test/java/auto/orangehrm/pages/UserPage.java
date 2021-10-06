/**
 * 
 */
package auto.orangehrm.pages;

import static java.util.Optional.ofNullable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import auto.orangehrm.model.User;
import auto.orangehrm.utils.Utils;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Abner Cruz Tovar <abnercruztovar@gmail.com>
 *
 */
public class UserPage extends PageObject {

	private static final String USER_ALREADY_EXIST = "/html/body/div[1]/div[3]/div/div[2]/form/fieldset/ol/li[3]/span";
	private static final String EMPLOYEE_NOT_EXIST = "/html/body/div[1]/div[3]/div/div[2]/form/fieldset/ol/li[2]/span";
	private static final String NO_RECORDS_FOUND = "/html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr/td";
	private static final String RECORDS_LIST = "//table[@id='resultTable']/tbody/*/td/a";
	private static final String CHK_TO_SELECT = "//table[@id='resultTable']/tbody/*/td/input[@type='checkbox']";

	private User user;

	@FindBy(id = "UserHeading")
	private WebElementFacade txtUserHeading;

	@FindBy(id = "systemUser_userType")
	private WebElementFacade lstRole;

	@FindBy(id = "systemUser_employeeName_empName")
	private WebElementFacade txtUserFullName;

	@FindBy(id = "systemUser_userName")
	private WebElementFacade txtUserName;

	@FindBy(id = "systemUser_status")
	private WebElementFacade lstStatus;

	@FindBy(id = "systemUser_password")
	private WebElementFacade txtPassword;

	@FindBy(id = "systemUser_confirmPassword")
	private WebElementFacade txtConfirmPassword;

	@FindBy(id = "btnSave")
	private WebElementFacade btnSave;

	@FindBy(id = "btnCancel")
	private WebElementFacade btnCancel;

	@FindBy(id = "errMessage")
	private WebElementFacade errMessage;

	@FindBy(id = "resultTable")
	private WebElementFacade tblResults;

	@FindBy(id = "btnDelete")
	private WebElementFacade btnDelete;

	@FindBy(id = "dialogDeleteBtn")
	private WebElementFacade btnConfirmDelete;

	@FindBy(id = "searchBtn")
	private WebElementFacade btnSearchUser;

	@FindBy(id = "resetBtn")
	private WebElementFacade btnResetSearch;

	@FindBy(id = "searchSystemUser_userName")
	private WebElementFacade txtSearchUser;

	@FindBy(id = "searchSystemUser_userType")
	private WebElementFacade searchLstRole;

	/**
	 * @return the txtUserHeading
	 */
	public WebElementFacade getTxtUserHeading() {
		return txtUserHeading;
	}

	/**
	 * @param txtUserHeading the txtUserHeading to set
	 */
	public void setTxtUserHeading(WebElementFacade txtUserHeading) {
		this.txtUserHeading = txtUserHeading;
	}

	/**
	 * @return the lstRole
	 */
	public WebElementFacade getLstRole() {
		return lstRole;
	}

	/**
	 * @param lstRole the lstRole to set
	 */
	public void setLstRole(WebElementFacade lstRole) {
		this.lstRole = lstRole;
	}

	/**
	 * @return the txtUserFullName
	 */
	public WebElementFacade getTxtUserFullName() {
		return txtUserFullName;
	}

	/**
	 * @param txtUserFullName the txtUserFullName to set
	 */
	public void setTxtUserFullName(WebElementFacade txtUserFullName) {
		this.txtUserFullName = txtUserFullName;
	}

	/**
	 * @return the txtUserName
	 */
	public WebElementFacade getTxtUserName() {
		return txtUserName;
	}

	/**
	 * @param txtUserName the txtUserName to set
	 */
	public void setTxtUserName(WebElementFacade txtUserName) {
		this.txtUserName = txtUserName;
	}

	/**
	 * @return the lstStatus
	 */
	public WebElementFacade getLstStatus() {
		return lstStatus;
	}

	/**
	 * @param lstStatus the lstStatus to set
	 */
	public void setLstStatus(WebElementFacade lstStatus) {
		this.lstStatus = lstStatus;
	}

	/**
	 * @return the txtPassword
	 */
	public WebElementFacade getTxtPassword() {
		return txtPassword;
	}

	/**
	 * @param txtPassword the txtPassword to set
	 */
	public void setTxtPassword(WebElementFacade txtPassword) {
		this.txtPassword = txtPassword;
	}

	/**
	 * @return the txtConfirmPassword
	 */
	public WebElementFacade getTxtConfirmPassword() {
		return txtConfirmPassword;
	}

	/**
	 * @param txtConfirmPassword the txtConfirmPassword to set
	 */
	public void setTxtConfirmPassword(WebElementFacade txtConfirmPassword) {
		this.txtConfirmPassword = txtConfirmPassword;
	}

	/**
	 * @return the btnSave
	 */
	public WebElementFacade getBtnSave() {
		return btnSave;
	}

	/**
	 * @param btnSave the btnSave to set
	 */
	public void setBtnSave(WebElementFacade btnSave) {
		this.btnSave = btnSave;
	}

	/**
	 * @return the btnCancel
	 */
	public WebElementFacade getBtnCancel() {
		return btnCancel;
	}

	/**
	 * @param btnCancel the btnCancel to set
	 */
	public void setBtnCancel(WebElementFacade btnCancel) {
		this.btnCancel = btnCancel;
	}

	/**
	 * @return the errMessage
	 */
	public WebElementFacade getErrMessage() {
		return errMessage;
	}

	/**
	 * @param errMessage the errMessage to set
	 */
	public void setErrMessage(WebElementFacade errMessage) {
		this.errMessage = errMessage;
	}

	/**
	 * @return the tblResults
	 */
	public WebElementFacade getTblResults() {
		return tblResults;
	}

	/**
	 * @param tblResults the tblResults to set
	 */
	public void setTblResults(WebElementFacade tblResults) {
		this.tblResults = tblResults;
	}

	/**
	 * @return the btnDelete
	 */
	public WebElementFacade getBtnDelete() {
		return btnDelete;
	}

	/**
	 * @param btnDelete the btnDelete to set
	 */
	public void setBtnDelete(WebElementFacade btnDelete) {
		this.btnDelete = btnDelete;
	}

	/**
	 * @return the btnConfirmDelete
	 */
	public WebElementFacade getBtnConfirmDelete() {
		return btnConfirmDelete;
	}

	/**
	 * @param btnConfirmDelete the btnConfirmDelete to set
	 */
	public void setBtnConfirmDelete(WebElementFacade btnConfirmDelete) {
		this.btnConfirmDelete = btnConfirmDelete;
	}

	/**
	 * @return the btnSearchUser
	 */
	public WebElementFacade getBtnSearchUser() {
		return btnSearchUser;
	}

	/**
	 * @param btnSearchUser the btnSearchUser to set
	 */
	public void setBtnSearchUser(WebElementFacade btnSearchUser) {
		this.btnSearchUser = btnSearchUser;
	}

	/**
	 * @return the btnResetSearch
	 */
	public WebElementFacade getBtnResetSearch() {
		return btnResetSearch;
	}

	/**
	 * @param btnResetSearch the btnResetSearch to set
	 */
	public void setBtnResetSearch(WebElementFacade btnResetSearch) {
		this.btnResetSearch = btnResetSearch;
	}

	/**
	 * @return the txtSearchUser
	 */
	public WebElementFacade getTxtSearchUser() {
		return txtSearchUser;
	}

	/**
	 * @param txtSearchUser the txtSearchUser to set
	 */
	public void setTxtSearchUser(WebElementFacade txtSearchUser) {
		this.txtSearchUser = txtSearchUser;
	}

	public void addUser(User user) {

		this.user = user;
		Utils.waitForClick(getDriver(), lstRole, 40);
		Select oRole = new Select(getLstRole());
		oRole.selectByVisibleText(user.getRole().toString());

		txtUserFullName.clear();
		txtUserFullName.sendKeys(user.getName());
		txtUserName.clear();
		txtUserName.sendKeys(user.getUserName());

		Utils.waitForClick(getDriver(), lstStatus, 40);
		Select oStatus = new Select(getLstStatus());
		oStatus.selectByVisibleText(user.getStatus().toString());

		txtPassword.clear();
		txtPassword.sendKeys(user.getPassword());
		txtConfirmPassword.clear();
		txtConfirmPassword.sendKeys(user.getPassword());

	}

	public String saveUser() {
		WebElement msjUSerExist = null;
		WebElement msjEmployeeNotExist = null;

		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 2);
			msjUSerExist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(USER_ALREADY_EXIST)));
			msjEmployeeNotExist = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMPLOYEE_NOT_EXIST)));
		} catch (Exception e) {
			e.getStackTrace();
		}

		if (msjUSerExist == null || msjEmployeeNotExist == null) {
			btnSave.click();
		}

		return ofNullable(msjUSerExist).map(m -> m.getText())
				.orElse(ofNullable(msjEmployeeNotExist).map(WebElement::getText).orElse(null));

	}

	public WebElement findUser(String userName, int param) {
		btnResetSearch.click();
		txtSearchUser.sendKeys(userName);
		btnSearchUser.click();

		String msjNoRecords = getDriver().findElement(By.xpath(NO_RECORDS_FOUND)).getText();
		if ("No Records Found".equals(msjNoRecords)) {
			return null;
		}

		List<WebElement> rows = getDriver().findElements(By.xpath(RECORDS_LIST));
		if (param == 0) {
			return getDriver().findElement(By.linkText(userName));
		} else if (param == 1) {
			return getDriver().findElement(By.xpath(CHK_TO_SELECT));

		} else {

			return null;
		}

	}

	/**
	 * Retorna una lista de WebElements de usuarios por rol
	 * 
	 * @param roleName
	 * @return
	 */
	public List<WebElement> searchUsersByRole(String roleName) {
		Utils.waitForClick(getDriver(), searchLstRole, 40);
		Select oRole = new Select(getSearchLstRole());
		oRole.selectByVisibleText(roleName);
		btnSearchUser.click();

		List<WebElement> rows = getDriver().findElements(By.xpath(RECORDS_LIST));

		return rows;
	}

	public void deleteUser(WebElement param) {
		btnDelete.click();
	}

	public void confirmDelete() {
		Utils.waitForClick(getDriver(), btnConfirmDelete, 40);
		btnConfirmDelete.click();
		btnResetSearch.click();
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the searchLstRole
	 */
	public WebElementFacade getSearchLstRole() {
		return searchLstRole;
	}

	/**
	 * @param searchLstRole the searchLstRole to set
	 */
	public void setSearchLstRole(WebElementFacade searchLstRole) {
		this.searchLstRole = searchLstRole;
	}
}
