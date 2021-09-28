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
public class AdminPage extends PageObject {

	@FindBy(id = "menu_admin_viewAdminModule")
	private WebElementFacade adminMenu;

	@FindBy(id = "menu_admin_UserManagement")
	private WebElementFacade adminUserManagement;

	@FindBy(id = "btnAdd")
	private WebElementFacade btnAddUser;

	@FindBy(id = "menu_pim_viewPimModule")
	private WebElementFacade pimMenu;

	@FindBy(id = "menu_pim_viewEmployeeList")
	private WebElementFacade pimEmployeeManagement;

	@FindBy(id = "btnAdd")
	private WebElementFacade btnAddEmployee;

	@FindBy(id = "resultTable")
	private WebElementFacade tblSearchResults;

	@FindBy(id = "btnSave")
	private WebElementFacade btnSave;

	/**
	 * @return the adminMenu
	 */
	public WebElementFacade getAdminMenu() {
		return adminMenu;
	}

	/**
	 * @param adminMenu the adminMenu to set
	 */
	public void setAdminMenu(WebElementFacade adminMenu) {
		this.adminMenu = adminMenu;
	}

	/**
	 * @return the adminUserManagement
	 */
	public WebElementFacade getAdminUserManagement() {
		return adminUserManagement;
	}

	/**
	 * @param adminUserManagement the adminUserManagement to set
	 */
	public void setAdminUserManagement(WebElementFacade adminUserManagement) {
		this.adminUserManagement = adminUserManagement;
	}

	/**
	 * @return the btnAddUser
	 */
	public WebElementFacade getBtnAddUser() {
		return btnAddUser;
	}

	/**
	 * @param btnAddUser the btnAddUser to set
	 */
	public void setBtnAddUser(WebElementFacade btnAddUser) {
		this.btnAddUser = btnAddUser;
	}

	/**
	 * @return the pimMenu
	 */
	public WebElementFacade getPimMenu() {
		return pimMenu;
	}

	/**
	 * @param pimMenu the pimMenu to set
	 */
	public void setPimMenu(WebElementFacade pimMenu) {
		this.pimMenu = pimMenu;
	}

	/**
	 * @return the pimEmployeeManagement
	 */
	public WebElementFacade getPimEmployeeManagement() {
		return pimEmployeeManagement;
	}

	/**
	 * @param pimEmployeeManagement the pimEmployeeManagement to set
	 */
	public void setPimEmployeeManagement(WebElementFacade pimEmployeeManagement) {
		this.pimEmployeeManagement = pimEmployeeManagement;
	}

	/**
	 * @return the btnAddEmployee
	 */
	public WebElementFacade getBtnAddEmployee() {
		return btnAddEmployee;
	}

	/**
	 * @param btnAddEmployee the btnAddEmployee to set
	 */
	public void setBtnAddEmployee(WebElementFacade btnAddEmployee) {
		this.btnAddEmployee = btnAddEmployee;
	}

	/**
	 * @return the tblSearchResults
	 */
	public WebElementFacade getTblSearchResults() {
		return tblSearchResults;
	}

	/**
	 * @param tblSearchResults the tblSearchResults to set
	 */
	public void setTblSearchResults(WebElementFacade tblSearchResults) {
		this.tblSearchResults = tblSearchResults;
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

}
